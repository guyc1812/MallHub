
// 获取全局应用程序实例对象
const app = getApp();

// 创建页面实例对象
Page({
  /**
   * 页面名称
   */
  name: "linrui",
 

  data: {
  
  
  },

  tap: function() {
    wx.navigateTo({
      url: '../mall/mall'
    })
  },

  
})

