
// 获取全局应用程序实例对象
const app = getApp();

// 创建页面实例对象
Page({
  
  name: "mall",
 
  
  data: {

		curNav:1,
		curIndex:0,

    mallInfo:{},
	
		navList:[
			{
				id:1,
				name:'B 1'
			},
			{
				id:2,
				name:'1 F'
			},
			{
				id:3,
				name:'2 F'
			},
			{
				id:4,
				name:'3 F'
			},
      	{
				id:5,
				name:'4 F'
			}
		],

    classifyList:[
			[
				{
					src:" ",
					name:"11",
				},
				{
					src:" ",
					name:"12",
				},
				{
					src:" ",
					name:"13",
				}
			],
			[
				{
				  src:" ",
					name:"21",
				},
				{
					src:" ",
					name:"22",
				}
			],
			[
				{
					src:" ",
					name:"31",
				},
				{
					src:" ",
					name:"32",
				}
			],
			[	{
					src:" ",
					name:"41",
				},
				{
					src:" ",
					name:"42",
				},
        {
					src:" ",
					name:"43",
				},
        {
					src:" ",
					name:"44",
				},
        {
					src:" ",
					name:"45",
				}
      ],
      [	{
					src:" ",
					name:"51",
				},
				{
					src:" ",
					name:"52",
				},
        {
					src:" ",
					name:"53",
				}
      ]
		],
  },
 more: function(){
	  wx.navigateTo({
        url: '../linrui/linrui'
      })
 },

 location: function(e) {
    console.log(e)
    wx.openLocation({
      latitude: this.data.mallInfo.latitude,
      longitude: this.data.mallInfo.longitude,
      scale: this.data.mallInfo.scale,
      name: this.data.mallInfo.name,
    })
  },

loadingChange () {//时间延迟，模仿加载
		setTimeout(() => {
			this.setData({
				hidden:true
			})
		},1000)
	},

onLoad (e) {

    var that = this;
    wx.request({
      url: 'http://localhost:8080/api/searchMallInfo?id='+e.id,
      success: function (res) {
        that.setData({ mallInfo: res.data });
        console.log(res.data)
      }
    })
    console.log(e.id)
    
		this.loadingChange()
	},

//选择分类
selectNav: function(event) {//event.target.dataset. 获取事件中的数据
		let id = event.target.dataset.id,
			index = parseInt(event.target.dataset.index);
			self = this;
		this.setData({
			curNav:id,
			curIndex:index
		})
	},

})

