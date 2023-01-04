import axios from "axios";
import { Modal } from "ant-design-vue";

let baseURL = "";

class HttpRequest {
  constructor() {
    // 存储请求队列
    this.queue = {};
  }

  getConfig() {
    const config = {
      baseUrl: baseURL,
      timeout: 60 * 1000,
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json; charset=utf-8",
      },
    };
    return config;
  }

  // 销毁请求实例
  destroy(url) {
    delete this.queue[url];
  }

  // 请求拦截
  interceptors(instance, url, nl) {
    // 添加请求拦截器
    instance.interceptors.request.use(
      (config) => {
        // 添加全局的loading...
        if (!Object.keys(this.queue).length && !nl) {
          // this.showLoading();
        }
        this.queue[url] = true;
        return config;
      },
      (error) => Promise.reject(error)
    );

    // 添加响应拦截器
    instance.interceptors.response.use(
      (res) => {
        this.destroy(url);
        // this.closeLoading();
        if (res.config && res.config.config && res.config.config.isUpload) {
          return res;
        }
        // 文件流不拦截
        if (res.data.constructor.prototype === new Blob().constructor.prototype)
          return res;
        const { data } = res;
        const is = this.destroy(url);
        if (!is) {
          // this.closeLoading();
        }
        if (data.success === true) {
            let datas = data.data
            return datas
        } else if (data.success === false) {
          Modal.error({
            content: `错误码：${data.code}
          错误信息：${data.msg}`,
            closable: true,
          });
          return false;
        }
      },
      (error) => {
        this.destroy(url);
        // this.closeLoading();

        if (error.message.includes("timeout")) {
          // Modal.error({ content: '请求超时，请检查网络是否连接正常' });
          return Promise.reject(error);
        }

        // const message500 = error.response.data.errorCode ? `错误号：${error.response.data.errorCode}
        //   错误信息：${error.response.data.errorMessage}` : '服务器内部错误，请联系技术支持';
        const { status } = error.response.status;
        // const message = error.response.message;
        switch (status) {
          case 401:
            sessionStorage.clear();
            // Modal.error({
            //   content: '登录失效，请重新从统一门户登录',
            //   closable: true,
            //   onOk: () => {
            //     location.reload();
            //   },
            // });
            break;
          case 500:
            // Modal.error({ content: message || message500, closable: true });
            break;
          case 417:
            // Modal.error({ content: message || error.response.data[0].message, closable: true });
            break;
          case 424:
            // Modal.error({ content: message || error.response.data[0].message, closable: true });
            break;
          default:
            if (!error.response) {
              // Modal.error({ content: '请求超时，请检查网络是否连接正常', closable: true });
            } else {
              // Modal.error({ content: '服务端异常，请联系技术支持', closable: true });
            }
            break;
        }
        return Promise.reject(error);
      }
    );
  }

  // 请求实例
  request(options) {
    const instance = axios.create();
    options = Object.assign(this.getConfig(options), options);
    this.interceptors(instance, options.url, options.nl);
    return instance(options);
  }
}

const httpRequest = new HttpRequest();

export const post = (url, param, isShowLoading) =>
  httpRequest.request({
    url,
    method: "post",
    data: param,
    isShowLoading,
  });
export const get = (url, param) =>
  httpRequest.request({
    url,
    method: "get",
    params: param,
  });

export const put = (url, param) =>
  httpRequest.request({
    url,
    method: "put",
    data: param,
  });

export const del = (url, param) =>
  httpRequest.request({
    url,
    method: "delete",
    data: param,
  });
export const url = baseURL;
export default httpRequest;
