
// 获取全局应用程序实例对象
const app = getApp();

// 创建页面实例对象
Page({

  name: "suzhou",

  data: {
    
    like:"false",
    
    malls: [
    // {
    //   zzsrc:"/pic/nzan.png",
    //   src: '/pic/link.png',
    //   name: '林瑞广场',
    //   describe: '全场双倍积分；\n部分商品五折优惠',
    //   tap: 'linrui',
    //   zanTap:'zanLinrui',
    // },{
    //   zzsrc:"/pic/nzan.png",
    //   src: '/pic/jiuguang.png',
    //   name: '久光百货',
    //   describe: '年终大抽奖；\n全场限时八折优惠',
    //   tap: 'jiuguang',
    //   zanTap:'zanJiuguang',
    // },{
    //   zzsrc:"/pic/nzan.png",
    //   src: '/pic/meiluo1.png',
    //   name: '美罗观前店',
    //   describe: '满500返50；\n积分抵现金',
    //   tap: 'meiluo1',
    //   zanTap:'zanMeiluo1',
    // },{
    //   zzsrc:"/pic/nzan.png",
    //   src: '/pic/xinsu.png',
    //   name: '新苏购物',
    //   describe: '跨店累计金额；\n全场满减送券',
    //   tap: 'xinsu',
    //   zanTap:'zanXinsu',
    // },{
    //   zzsrc:"/pic/nzan.png",
    //   src: '/pic/meiluo2.png',
    //   name: '美罗新区店',
    //   describe: '满500返50；\n积分抵现金',
    //   tap: 'meiluo2',
    //   zanTap:'zanMeiluo2',
    // }
    ],


  },

  navTo: function(e) {
      console.log(e);
      wx.navigateTo({
        url: '../mall/mall?id=' + e.currentTarget.dataset.tap
      })
  },

  tap: function() {
      wx.navigateTo({
        url: '../mall/mall'
      })
  },

  

  zan: function(e) {
     console.log(e)
     var that = this
     if(this.data.like == true){
        that.setData({like:false})
        var i = e.target.dataset.index
        this.data.malls[i].zzsrc = '/pic/nzan.png'
        that.setData({malls:this.data.malls})
     }else{
        that.setData({like:true})
        var i = e.target.dataset.index
        this.data.malls[i].zzsrc = '/pic/zan.png'
        that.setData({malls:this.data.malls})
     } 
  },


  onLoad: function () {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/api/searchMalls', 
      success: function (res) {
        that.setData({ malls : res.data.mallList});
        // that.data.malls = res.mallList;


        console.log(that.data)
      }
    })
  }

})

