//index.js
//获取应用实例
var app = getApp()
Page({
  data: {
    hidden:true,
    motto: 'Mall Hub',
    userInfo: {},
    animationData1:[],
    animationData2:[]
  },
  //事件处理函数
  login: function() {
    const s =this 

    var animation2 = wx.createAnimation({
      transformOrigin: "50% 50%",
      duration: 2000,
      timingFunction: "linear",
      delay: 0
    })

    animation2.scale(0.8).translateX(-75).step()
    this.setData({animationData2:animation2.export()})

    var animation1 = wx.createAnimation({
      transformOrigin: "50% 50%",
      duration: 2000,
      timingFunction: "linear",
      delay: 0
    })

    animation1.translateY(149).translateX(75).step()
    this.setData({animationData1:animation1.export()})
    setTimeout(
      function() { 
        s.setData({hidden:false})
      }, 2200)
    
      
    setTimeout(function(){
      wx.navigateTo({url: '../city/city'})
    },3000)

 
  },
  onLoad: function () {
    console.log('onLoad')
    var that = this
    app.getUserInfo(function(userInfo){
      that.setData({userInfo:userInfo})
      that.setData({condition:true})
    })
   
  }
})
