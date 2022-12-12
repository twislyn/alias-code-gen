import api from "@/config/api";
import { get, post } from "@/utils/axios";

export const initApi = () => get(`${api.init}`);

export const getTablesApi = (data) => post(`${api.tables}`, data);

export const generateCodeApi = (data) => post(`${api.generateCode}`, data);
