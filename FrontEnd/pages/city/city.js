// 获取全局应用程序实例对象
const app = getApp();

// 创建页面实例对象
Page({
  
  data: { 
    
      city:'CITY',
      qita:["杭州","沈阳","重庆","南京","合肥","长春"], 
      remen:["北京","上海","苏州","天津","深圳","广州"], 
  },

  xuanze:function(e){
    console.log(e);
    var c = this.data.city;
    var id = e.currentTarget.id;
    console.log(id);
    console.log(c);
    c = id;
    console.log(c);
    this.setData({city:c});

  },
  
  tap: function() {
    wx.navigateTo({
      url: '../suzhou/suzhou'
    })
  },

})

