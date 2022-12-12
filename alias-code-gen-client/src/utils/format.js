export const formatListToOptions = (list, labelName, valueName) => {
    const options = []
    if (!list || list.length <= 0) {
      return options
    }
  
    list.forEach(item => {
      options.push({
        label: item[labelName],
        value: item[valueName]
      })
    })
    return options
  }
  