<template>
  <div style="background-color:#292929">
    <el-container style="height: 800px;background-color: white">
<!--      <el-header>-->
<!--&lt;!&ndash;        <el-menu&ndash;&gt;-->
<!--&lt;!&ndash;            :default-active="activeIndex2"&ndash;&gt;-->
<!--&lt;!&ndash;            class="el-menu-demo"&ndash;&gt;-->
<!--&lt;!&ndash;            mode="horizontal"&ndash;&gt;-->
<!--&lt;!&ndash;            @select="handleSelect"&ndash;&gt;-->
<!--&lt;!&ndash;            background-color="#292929"&ndash;&gt;-->
<!--&lt;!&ndash;            text-color="#fff"&ndash;&gt;-->
<!--&lt;!&ndash;            active-text-color="#ffd04b">&ndash;&gt;-->
<!--&lt;!&ndash;          <el-menu-item index="1">处理中心</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;          <el-submenu index="2">&ndash;&gt;-->
<!--&lt;!&ndash;            <template slot="title">我的工作台</template>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-menu-item index="2-1">选项1</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-menu-item index="2-2">选项2</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-menu-item index="2-3">选项3</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;            <el-submenu index="2-4">&ndash;&gt;-->
<!--&lt;!&ndash;              <template slot="title">选项4</template>&ndash;&gt;-->
<!--&lt;!&ndash;              <el-menu-item index="2-4-1">选项1</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;              <el-menu-item index="2-4-2">选项2</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;              <el-menu-item index="2-4-3">选项3</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;            </el-submenu>&ndash;&gt;-->
<!--&lt;!&ndash;          </el-submenu>&ndash;&gt;-->
<!--&lt;!&ndash;          <el-menu-item index="3" disabled>消息中心</el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;          <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>&ndash;&gt;-->
<!--&lt;!&ndash;        </el-menu>&ndash;&gt;-->
<!--      </el-header>-->
      <el-container>
        <!--左侧部分-->
        <el-aside width="200px">
          <!--          <el-button round style="margin-left: 45px">圆角按钮</el-button>-->
          <el-button type="primary" round style="margin-top: 35px" @click="drawTypeChange('')">Drag</el-button><br>
          <el-button type="primary" round style="margin-top: 35px" @click="peer_click">Peer</el-button>
          <el-button type="primary" round style="margin-top: 35px" @click="tri_click">Organization</el-button>
          <el-button type="primary" round style="margin-top: 35px" @click="drawTypeChange('xu_ellipse')">Organization Area</el-button>
          <el-button type="primary" round style="margin-top: 35px" @click="drawTypeChange('ellipse')">Channel</el-button>
          <el-button type="primary" round style="margin-top: 35px" @click="drawTypeChange('rectangle')">Blockchain Network</el-button>
          <el-button type="primary" round style="margin-top: 35px" @click="drawTypeChange('line')">PA</el-button>
          <el-button type="primary" round style="margin-top: 20px" @click="app_click">Application</el-button>
          <el-button type="primary" round style="margin-top: 20px" @click="drawPolygon">Ledger</el-button>
          <!--          <el-menu :default-openeds="['1', '3']" style="background-color: #292929" text-color="#fff">-->
          <!--            <el-submenu index="1" style="background-color: #292929">-->
          <!--              <template slot="title"><i class="el-icon-message"></i>图形</template>-->
          <!--              <el-menu-item-group style="background-color:lightgray" >-->

          <!--                <template slot="title">矩形</template>-->
          <!--                <el-menu-item index="1-1">直角矩形</el-menu-item>-->
          <!--                <el-menu-item index="1-2">圆角矩形</el-menu-item>-->
          <!--              </el-menu-item-group>-->
          <!--            </el-submenu>-->
          <!--            <el-submenu index="2">-->
          <!--              <template slot="title"><i class="el-icon-menu"></i>导航二</template>-->
          <!--              <el-menu-item-group>-->
          <!--                <template slot="title">分组一</template>-->
          <!--                <el-menu-item index="2-1">选项1</el-menu-item>-->
          <!--                <el-menu-item index="2-2">选项2</el-menu-item>-->
          <!--              </el-menu-item-group>-->
          <!--              <el-menu-item-group title="分组2">-->
          <!--                <el-menu-item index="2-3">选项3</el-menu-item>-->
          <!--              </el-menu-item-group>-->
          <!--              <el-submenu index="2-4">-->
          <!--                <template slot="title">选项4</template>-->
          <!--                <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
          <!--              </el-submenu>-->
          <!--            </el-submenu>-->

          <!--          </el-menu>-->
        </el-aside>
        <!--右侧部分-->
        <el-main>
          <div class="maintenancePlanAdd">
            <div class="child-panel-title" style="margin-top: 0px">
              <el-button type="primary" round style="margin-top: 20px" @click="blue_click">Blue</el-button>
              <el-button type="purple" round style="margin-top: 20px" @click="purple_click">Purple</el-button>
              <el-button type="red" round style="margin-top: 20px" @click="red_click">Red</el-button>
              <el-button type="green" round style="margin-top: 20px" @click="green_click">Green</el-button>
              <el-button type="yellow" round style="margin-top: 20px" @click="yellow_click">Yellow</el-button>
              <el-button type="orange" round style="margin-top: 20px" @click="orange_click">Orange</el-button>
            </div>
            <div class="panel-body" style="margin-top: 40px">
              <div class="demo">
                <canvas id="canvas" :width="width" :height="height"></canvas>
<!--                <img id="img1" src="../assets/example.png" style="height:20px; width: 20px;">-->
                <div class="draw-btn-group">
                  <div :class="{active:drawType==''}" title="自由选择" @click="drawTypeChange('')">
                    <i class="draw-icon icon-mouse"></i>
                  </div>
                  <div :class="{active:drawType=='line'}" title="画箭头" @click="drawTypeChange('line')">
                    <i class="draw-icon icon-1"></i>
                  </div>
                  <div :class="{active:drawType=='text'}" title="文本输入框" @click="drawTypeChange('text')">
                    <i class="draw-icon icon-2"></i>
                  </div>
                  <div :class="{active:drawType=='ellipse'}" title="画圆" @click="drawTypeChange('ellipse')">
                    <i class="draw-icon icon-3"></i>
                  </div>
                  <div :class="{active:drawType=='rectangle'}" title="画矩形" @click="drawTypeChange('rectangle')">
                    <i class="draw-icon icon-4"></i>
                  </div>
                  <div :class="{active:drawType=='polygon'}" title="画多边形" @click="drawPolygon">
                    <i class="draw-icon icon-6"></i>
                  </div>
                  <div :class="{active:drawType=='pen'}" title="笔画" @click="drawTypeChange('pen')">
                    <i class="draw-icon icon-7"></i>
                  </div>
                  <div :class="{active:drawType=='pentagram'}" title="五角星" @click="drawTypeChange('pentagram')">
                    <i class="draw-icon icon-pentagram"></i>
                  </div>
                  <div @click="uploadImg" title="从文件选择图片上传">
                    <i class="draw-icon icon-img"></i>
                  </div>
                  <div @click="save" title="保存">
                    <i class="draw-icon icon-save"></i>
                  </div>
                  <div @click="download" title="保存zip文件">
                    <i class="draw-icon icon-zip"></i>
                  </div>
                </div>
              </div>
            </div>
            <input type="file" @change="uploadImgChange" id="imgInput" accept="image/*" />
            <img id="img" :src="imgSrc" />
            <img id="expImg" src="../assets/icons/draw/exp.jpg" />
          </div>
<!--          <div class="box peer">-->
<!--            <div class="box pic1" v-drag v-if="pic == 'pic1'" key="pic1"></div>-->
<!--            <div class="box pic2" v-else-if="pic === 'pic2'" key="pic2"></div>-->
<!--            <div class="box pic0" v-else-if="pic === 'pic0'" key="pic0"></div>-->
<!--            <div class="box pic3" v-else key="pic3"></div>-->
<!--          </div>-->
<!--          <div class="box org">-->
<!--            <div class="box org1" v-drag v-if="org === 'org1'" key="org1"></div>-->
<!--            <div class="box org0" v-else key="org0"></div>-->
<!--          </div>-->
<!--          <div class="box app">-->
<!--            <div class="box app1" v-drag v-if="app === 'app1'" key="app1"></div>-->
<!--            <div class="box app0" v-else key="app0"></div>-->
<!--          </div>-->
<!--          <div class="box cha">-->
<!--            <div class="box cha1" v-drag v-if="cha === 'cha1'" key="cha1"></div>-->
<!--            <div class="box cha0" v-else key="cha0"></div>-->
<!--          </div>-->
<!--          <div class="box blo">-->
<!--            <div class="box blo1" v-drag v-if="blo === 'blo1'" key="blo1"></div>-->
<!--            <div class="box blo0" v-else key="blo0"></div>-->
<!--          </div>-->

        </el-main>
      </el-container>

    </el-container>


<!--    <el-row>-->
<!--      &lt;!&ndash;      <el-button icon="el-icon-search" circle></el-button>&ndash;&gt;-->
<!--      <el-button type="primary" icon="el-icon-edit" circle></el-button>-->
<!--      <el-button type="primary" icon="el-icon-edit" circle></el-button>-->
<!--      <el-button type="primary" icon="el-icon-edit" circle></el-button>-->
<!--      <el-button type="primary" icon="el-icon-edit" circle></el-button>-->
<!--      <el-button type="primary" icon="el-icon-edit" circle></el-button>-->
<!--      <el-button type="primary" icon="el-icon-edit" circle></el-button>-->
<!--    </el-row>-->
  </div>

</template>


<script>

export default{
  name:"DrawEl",
  
  data(){
    return {
      // 加了toController_的，都是之后传给Controller时会用到的数据，与下面分离！
      // ----- 睿睿
      /* -------------------------------------------
          orgs里面有peers[]，用数字表示这个org里面是哪几个peer。
          这里的数字为全局的p_count
       */
      all_orgs: {
        red:{
          org_peercount: 0,
          org_ordercount: 0,
          peers: {},
          orderers: {}
        },
        blue:{
          org_peercount: 0,
          org_ordercount: 0,
          peers: {},
          orderers: {}
        },
        darkgreen:{
          org_peercount: 0,
          org_ordercount: 0,
          peers: {},
          orderers: {}
        },
        gold:{
          org_peercount: 0,
          org_ordercount: 0,
          peers: {},
          orderers: {}
        },
        purple:{
          org_peercount: 0,
          org_ordercount: 0,
          peers: {},
          orderers: {}
        },
        orange:{
          org_peercount: 0,
          org_ordercount: 0,
          peers: {},
          orderers: {}
        }
      },
      toController_orgs: {},
      toController_channels: {},

      flag:1,
      peer_color:'red',
      org_color:'red',
      app_color:'red',
      o_count:0,
      p_count:0,
      a_count:0,
      pic: 'pic0',
      org: 'org0',
      app: 'app0',
      cha: 'cha0',
      blo: 'blo0',
      width: 1080,
      height: 550,
      rect: [],
      canvas: {},
      showMenu: false,
      x: "",
      y: "",
      mouseFrom: {},
      mouseTo: {},
      drawType: null,  //当前绘制图像的种类
      canvasObjectIndex: 0,
      textbox: null,
      rectangleLabel: "warning",
      drawWidth: 2, //笔触宽度
      color: "#E34F51", //画笔颜色
      drawingObject: null, //当前绘制对象
      moveCount: 1, //绘制移动计数器
      doDrawing: false, // 绘制状态
      //polygon 相关参数
      polygonMode: false,
      pointArray: [],
      lineArray: [],
      activeShape: false,
      activeLine: "",
      line: {},
      delectKlass: {},
      imgFile: {},
      imgSrc: "",
    };
  },
  directives: {
    drag: {
      // 指令的定义
      bind: function(el) {
        let oDiv = el;  // 获取当前元素
        oDiv.onmousedown = (e) => {
          // 算出鼠标相对元素的位置
          let disX = e.clientX - oDiv.offsetLeft;
          let disY = e.clientY - oDiv.offsetTop;

          document.onmousemove = (e) => {
            // 用鼠标的位置减去鼠标相对元素的位置，得到元素的位置
            let left = e.clientX - disX;
            let top = e.clientY - disY;

            oDiv.style.left = left + 'px';
            oDiv.style.top = top + 'px';
          };

          document.onmouseup = (e) => {
            document.onmousemove = null;
            document.onmouseup = null;
          }
        }
      }
    }
  },
  watch: {
    drawType() {
      this.canvas.selection = !this.drawType;
    },
    width() {
      this.canvas.setWidth(this.width)
    },
    height() {
      this.canvas.setHeight(this.height)
    },
  },
  methods:{

    red_click(){
      this.peer_color='red';
      this.org_color='red';
      this.app_color='red';
    },
    blue_click(){
      this.peer_color='blue';
      this.org_color='blue';
      this.app_color='blue';
    },
    green_click(){
      this.peer_color='darkgreen';
      this.org_color='darkgreen';
      this.app_color='darkgreen';
    },
    yellow_click(){
      this.peer_color='gold';
      this.org_color='gold';
      this.app_color='gold';
    },
    purple_click(){
      this.peer_color='purple';
      this.org_color='purple';
      this.app_color='purple';
    },
    orange_click(){
      this.peer_color='orange';
      this.org_color='orange';
      this.app_color='orange';
    },

    addOrg(){
      let tempOrg = this.all_orgs[this.org_color];
      this.toController_orgs[this.org_color] = {
        id: this.o_count,
        name: this.org_color,
        peers: tempOrg.peers,
        orderers: tempOrg.orderers,
        org_peercount: tempOrg.peers.count,
        org_orderercount: tempOrg.orderers.count
      }
    },

    addPeer(org){
      let tempOrg = '';
      if(this.toController_orgs[org]){
        tempOrg = this.toController_orgs[org];
      }
      else{
        tempOrg = this.all_orgs[org];
      }
      let index = tempOrg.org_peercount;
      tempOrg.peers[index] = this.p_count;
      tempOrg.org_peercount += 1;
    },

    peer_click(){
      this.p_count++;
      var p = 'P' + this.p_count;
      var rect = new fabric.Rect({
        // left:100,//距离画布左侧的距离，单位是像素
        // top:100,//距离画布上边的距离
        originX: 'center',
        originY: 'center',
        fill:this.peer_color,//填充的颜色
        width:50,//方形的宽度
        height:50,//方形的高度
        rx:8,
        ry:8,
        stroke:'#336699',
        strokeWidth:2
      });
      var text = new fabric.Text(p,{
        fontSize: 25,
        fill:'white',
        originX: 'center',
        originY: 'center'
      });
      var group = new fabric.Group([rect, text], {
        left: 150,
        top: 100
      })
      this.canvas.add(group);
      this.addPeer(this.peer_color);
    },
    tri_click(){
      this.o_count++;
      var o = 'Org' + this.o_count;
      var triangle = new fabric.Triangle({
        left:50,
        top:50,
        fill:this.org_color,
        width:50,
        height:45,
        stroke:'#336699',
        strokeWidth:2
      });
      var text = new fabric.Text(o,{
        fontSize: 13,
        fill: 'white',
        left:63,
        top:72
      });
      var group = new fabric.Group([triangle, text], {
        left: 100,
        top: 100
      })
      this.canvas.add(group);
      this.addOrg();
    },
    app_click(){
      this.a_count++;
      var a = 'App' + this.a_count;
      var rect = new fabric.Rect({
        // left:100,//距离画布左侧的距离，单位是像素
        // top:100,//距离画布上边的距离
        originX: 'center',
        originY: 'center',
        stroke:this.app_color,
        strokeWidth:2,
        fill:'rgba(255,255,255,0)',//填充的颜色
        width:50,//方形的宽度
        height:50,//方形的高度
        rx:8,
        ry:8,
      });
      var text = new fabric.Text(a,{
        fontSize: 20,
        fill:this.app_color,
        originX: 'center',
        originY: 'center'
      });
      var group = new fabric.Group([rect, text], {
        left: 250,
        top: 100
      })
      this.canvas.add(group);
    },

    // 下载zip文件
    download(){
      let temp = this
      // let instance = this.$axios.create()
      // instance.defaults.headers.post['Content-Type'] = 'application/json'
      this.$axios({
        method: 'POST',
        url: '/download',
        data: {
          jsonOrgs: JSON.stringify(temp.toController_orgs),
          jsonChannels: JSON.stringify(temp.toController_channels)
        },
        responseType: 'blob'
      }).then(response => {      // 后台返回的文件流直接放在response里
            console.log(response)
            const blob = new Blob([response.data])
            const url = window.URL.createObjectURL(blob)
            let link = document.createElement('a')     // 用a标签实现下载
            link.href = url
            link.style.display = 'none'
            link.setAttribute('download', 'fabric-draw.zip')
            document.body.appendChild(link)
            link.click()
          })
    },

    // 保存当前画布为png图片
    save() {
      var canvas = document.getElementById('canvas')
      var imgData = canvas.toDataURL('png');
      imgData = imgData.replace('image/png', 'image/octet-stream');
      // 下载后的问题名，可自由指定
      var filename = 'drawingboard_' + (new Date()).getTime() + '.' + 'png';
      this.saveFile(imgData, filename);
    },
    saveFile(data, filename) {
      var save_link = document.createElement('a');
      save_link.href = data;
      save_link.download = filename;
      var event = document.createEvent('MouseEvents');
      event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
      save_link.dispatchEvent(event);
    },
    uploadImg() {
      document.getElementById("imgInput").click();
    },
    // 从已渲染的DOM元素加载图片至canvas
    loadExpImg() {
      var imgElement = document.getElementById("expImg"); //声明我们的图片
      var imgInstance = new fabric.Image(imgElement, {
        selectable: false
        // zIndex:-99,
      });
      this.canvas.add(imgInstance);
    },
    // 从文件加载图片至canvas
    uploadImgChange() {
      // 获取文件
      var eleImportInput = document.getElementById("imgInput");
      this.imgFile = eleImportInput.files[0];
      var imgSrc = "",
          imgTitle = "";
      // 从reader中获取选择文件的src
      if (/\.(jpe?g|png|gif)$/i.test(this.imgFile.name)) {
        var reader = new FileReader();
        var _this = this;
        reader.addEventListener(
            "load",
            function () {
              imgTitle = _this.imgFile.name;
              _this.imgSrc = this.result;
            },
            false
        );
        reader.readAsDataURL(this.imgFile);
      }
      var imgElement = document.getElementById("img"); //声明我们的图片
      imgElement.onload = () => {
        this.width = imgElement.width
        this.height = imgElement.height
        var imgInstance = new fabric.Image(imgElement, {
          zIndex: -1,
          selectable: false
        });
        this.canvas.add(imgInstance);
      };
    },
    // 开始绘制时，指定绘画种类
    drawTypeChange(e) {
      this.drawType = e;
      this.canvas.skipTargetFind = !!e
      if (e == "pen") {
        // isDrawingMode为true 才可以自由绘画
        this.canvas.isDrawingMode = true;
      } else {
        this.canvas.isDrawingMode = false;
      }
    },
    // 鼠标按下时触发
    mousedown(e) {
      // 记录鼠标按下时的坐标
      var xy = e.pointer || this.transformMouse(e.e.offsetX, e.e.offsetY);
      this.mouseFrom.x = xy.x;
      this.mouseFrom.y = xy.y;
      this.doDrawing = true;
      if (this.drawType == "text") {
        this.drawing();
      }
      if (this.textbox) {
        this.textbox.enterEditing();
        this.textbox.hiddenTextarea.focus();
      }
      // 绘制多边形
      if (this.drawType == "polygon") {
        this.canvas.skipTargetFind = false;
        try {
          // 此段为判断是否闭合多边形，点击红点时闭合多边形
          if (this.pointArray.length > 1) {
            // e.target.id == this.pointArray[0].id 表示点击了初始红点
            if (e.target && e.target.id == this.pointArray[0].id) {
              this.generatePolygon();
            }
          }
          //未点击红点则继续作画
          if (this.polygonMode) {
            this.addPoint(e);
          }
        } catch (error) {
          console.log(error);
        }
      }
    },
    // 鼠标松开执行
    mouseup(e) {
      var xy = e.pointer || this.transformMouse(e.e.offsetX, e.e.offsetY);
      this.mouseTo.x = xy.x;
      this.mouseTo.y = xy.y;
      this.drawingObject = null;
      this.moveCount = 1;
      if (this.drawType != "polygon") {
        this.doDrawing = false;
      }
    },
    //鼠标移动过程中已经完成了绘制
    mousemove(e) {
      if (this.moveCount % 2 && !this.doDrawing) {
        //减少绘制频率
        return;
      }
      this.moveCount++;
      var xy = e.pointer || this.transformMouse(e.e.offsetX, e.e.offsetY);
      this.mouseTo.x = xy.x;
      this.mouseTo.y = xy.y;
      // 多边形与文字框特殊处理
      if (this.drawType != "text" || this.drawType != "polygon") {
        this.drawing(e);
      }
      if (this.drawType == "polygon") {
        if (this.activeLine && this.activeLine.class == "line") {
          var pointer = this.canvas.getPointer(e.e);
          this.activeLine.set({ x2: pointer.x, y2: pointer.y });
          var points = this.activeShape.get("points");
          points[this.pointArray.length] = {
            x: pointer.x,
            y: pointer.y,
            zIndex: 1
          };
          this.activeShape.set({
            points: points
          });
          this.canvas.renderAll();
        }
        this.canvas.renderAll();
      }
    },
    deleteObj() {
      this.canvas.getActiveObjects().map(item => {
        this.canvas.remove(item);
      });
    },
    transformMouse(mouseX, mouseY) {
      return { x: mouseX / 1, y: mouseY / 1 };
    },
    // 绘制多边形开始，绘制多边形和其他图形不一样，需要单独处理
    drawPolygon() {
      this.color = "black";
      this.drawType = "polygon";
      this.polygonMode = true;
      //这里画的多边形，由顶点与线组成
      this.pointArray = new Array();  // 顶点集合
      this.lineArray = new Array();  //线集合
      this.canvas.isDrawingMode = false;
    },
    addPoint(e) {
      var random = Math.floor(Math.random() * 10000);
      var id = new Date().getTime() + random;
      var circle = new fabric.Circle({
        radius: 5,
        fill: "#ffffff",
        stroke: "#333333",
        strokeWidth: 0.5,
        left: (e.pointer.x || e.e.layerX) / this.canvas.getZoom(),
        top: (e.pointer.y || e.e.layerY) / this.canvas.getZoom(),
        selectable: false,
        hasBorders: false,
        hasControls: false,
        originX: "center",
        originY: "center",
        id: id,
        objectCaching: false
      });
      if (this.pointArray.length == 0) {
        circle.set({
          fill: "red"
        });
      }
      var points = [
        (e.pointer.x || e.e.layerX) / this.canvas.getZoom(),
        (e.pointer.y || e.e.layerY) / this.canvas.getZoom(),
        (e.pointer.x || e.e.layerX) / this.canvas.getZoom(),
        (e.pointer.y || e.e.layerY) / this.canvas.getZoom()
      ];
      this.line = new fabric.Line(points, {
        strokeWidth: 2,
        fill: "#999999",
        stroke: "#999999",
        class: "line",
        originX: "center",
        originY: "center",
        selectable: false,
        hasBorders: false,
        hasControls: false,
        evented: false,
        objectCaching: false
      });
      if (this.activeShape) {
        var pos = this.canvas.getPointer(e.e);
        var points = this.activeShape.get("points");
        points.push({
          x: pos.x,
          y: pos.y
        });
        var polygon = new fabric.Polygon(points, {
          stroke: "#333333",
          strokeWidth: 1,
          fill: "#cccccc",
          opacity: 0.3,
          selectable: false,
          hasBorders: false,
          hasControls: false,
          evented: false,
          objectCaching: false
        });
        this.canvas.remove(this.activeShape);
        this.canvas.add(polygon);
        this.activeShape = polygon;
        this.canvas.renderAll();
      } else {
        var polyPoint = [
          {
            x: (e.pointer.x || e.e.layerX) / this.canvas.getZoom(),
            y: (e.pointer.y || e.e.layerY) / this.canvas.getZoom()
          }
        ];
        var polygon = new fabric.Polygon(polyPoint, {
          stroke: "#333333",
          strokeWidth: 1,
          fill: "#cccccc",
          opacity: 0.3,
          selectable: false,
          hasBorders: false,
          hasControls: false,
          evented: false,
          objectCaching: false
        });
        this.activeShape = polygon;
        this.canvas.add(polygon);
      }
      this.activeLine = this.line;
      this.pointArray.push(circle);
      this.lineArray.push(this.line);
      this.canvas.add(this.line);
      this.canvas.add(circle);
    },
    generatePolygon() {
      var points = new Array();
      this.pointArray.map((point, index) => {
        points.push({
          x: point.left,
          y: point.top
        });
        this.canvas.remove(point);
      });
      this.lineArray.map((line, index) => {
        this.canvas.remove(line);
      });
      this.canvas.remove(this.activeShape).remove(this.activeLine);
      var polygon = new fabric.Polygon(points, {
        stroke: this.color,
        strokeWidth: this.drawWidth,
        fill: "rgba(255, 255, 255, 0)",
        opacity: 1,
        hasBorders: true,
        hasControls: false
      });
      this.canvas.add(polygon);
      this.activeLine = null;
      this.activeShape = null;
      this.polygonMode = false;
      this.doDrawing = false;
      this.drawType = null;
    },
    drawing(e) {
      if (this.drawingObject) {
        this.canvas.remove(this.drawingObject);
      }
      var canvasObject = null;
      var left = this.mouseFrom.x,
          top = this.mouseFrom.y,
          mouseFrom = this.mouseFrom,
          mouseTo = this.mouseTo;
      switch (this.drawType) {
        case "line":
          this.color = "#336699";
          var line = new fabric.Line([mouseFrom.x,mouseFrom.y,mouseTo.x,mouseTo.y],{
            stroke: this.color,
            fill: 'green',
            strokeWidth: 3,
          });
          var circle = new fabric.Circle({
            left:mouseFrom.x-2.5,
            top:mouseFrom.y-2.5,
            radius: 5,
            fill:'#336699'
          });
          var circle2 = new fabric.Circle({
            left:mouseTo.x-2.5,
            top:mouseTo.y-2.5,
            radius: 5,
            fill:'#336699'
          });
          canvasObject = new fabric.Group([line, circle,circle2], {
            left: mouseFrom.x,
            top: mouseFrom.y
          });
          break;
        case "arrow": //箭头
          var x1 = mouseFrom.x,
              x2 = mouseTo.x,
              y1 = mouseFrom.y,
              y2 = mouseTo.y;
          var w = x2 - x1,
              h = y2 - y1,
              sh = Math.cos(Math.PI / 4) * 16;
          var sin = h / Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));
          var cos = w / Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));
          var w1 = (16 * sin) / 4,
              h1 = (16 * cos) / 4,
              centerx = sh * cos,
              centery = sh * sin;
          /**
           * centerx,centery 表示起始点，终点连线与箭头尖端等边三角形交点相对x，y
           * w1 ，h1用于确定四个点
           */
          var path = " M " + x1 + " " + y1;
          path += " L " + (x2 - centerx + w1) + " " + (y2 - centery - h1);
          path +=
              " L " + (x2 - centerx + w1 * 2) + " " + (y2 - centery - h1 * 2);
          path += " L " + x2 + " " + y2;
          path +=
              " L " + (x2 - centerx - w1 * 2) + " " + (y2 - centery + h1 * 2);
          path += " L " + (x2 - centerx - w1) + " " + (y2 - centery + h1);
          path += " Z";
          canvasObject = new fabric.Path(path, {
            stroke: this.color,
            fill: this.color,
            strokeWidth: this.drawWidth
          });
          break;
        case "pentagram": //五角星
          var x1 = mouseFrom.x,
              x2 = mouseTo.x,
              y1 = mouseFrom.y,
              y2 = mouseTo.y;
          /**
           * 实现思路  (x1,y1)表示鼠标起始的位置 (x2,y2)表示鼠标抬起的位置
           * r 表示五边形外圈圆的半径，这里建议自己画个图理解
           * 正五边形夹角为36度。计算出cos18°，sin18°备用
           */
          var w = Math.abs(x2 - x1),
              h = Math.abs(y2 - y1),
              r = Math.sqrt(w * w + h * h)
          var cos18 = Math.cos(18 * Math.PI / 180)
          var sin18 = Math.sin(18 * Math.PI / 180)
          /**
           * 算出对应五个点的坐标转化为路径
           */
          var point1 = [x1, y1 + r]
          var point2 = [x1 + 2 * r * (sin18), y1 + r - 2 * r * (cos18)]
          var point3 = [x1 - r * (cos18), y1 + r * (sin18)]
          var point4 = [x1 + r * (cos18), y1 + r * (sin18)]
          var point5 = [x1 - 2 * r * (sin18), y1 + r - 2 * r * (cos18)]
          var path = " M " + point1[0] + " " + point1[1]
          path += " L " + point2[0] + " " + point2[1]
          path += " L " + point3[0] + " " + point3[1]
          path += " L " + point4[0] + " " + point4[1]
          path += " L " + point5[0] + " " + point5[1]
          path += " Z";
          canvasObject = new fabric.Path(path, {
            stroke: this.color,
            fill: this.color,
            strokeWidth: this.drawWidth,
            // angle:180,  //设置旋转角度
          });
          break;
        case "xu_ellipse": //椭圆// 按shift时画正圆，只有在鼠标移动时才执行这个，所以按了shift但是没有拖动鼠标将不会画圆
          this.color = this.org_color;
          if (e.e.shiftKey) {
            mouseTo.x - left > mouseTo.y - top ? mouseTo.y = top + mouseTo.x - left : mouseTo.x = left + mouseTo.y - top
          }
          var radius =
              Math.sqrt(
                  (mouseTo.x - left) * (mouseTo.x - left) +
                  (mouseTo.y - top) * (mouseTo.y - top)
              ) / 2;
          canvasObject = new fabric.Ellipse({
            left: (mouseTo.x - left) / 2 + left,
            top: (mouseTo.y - top) / 2 + top,
            stroke: this.color,
            fill: "rgba(255, 255, 255, 0)",
            originX: "center",
            originY: "center",
            rx: Math.abs(left - mouseTo.x) / 2,
            ry: Math.abs(top - mouseTo.y) / 2,
            strokeWidth: this.drawWidth,
            strokeDashArray: [5,2]
          });
          break;
        case "ellipse": //椭圆 // 按shift时画正圆，只有在鼠标移动时才执行这个，所以按了shift但是没有拖动鼠标将不会画圆

          this.color = "#336699";
          if (e.e.shiftKey) {
            mouseTo.x - left > mouseTo.y - top ? mouseTo.y = top + mouseTo.x - left : mouseTo.x = left + mouseTo.y - top
          }
          var radius =
              Math.sqrt(
                  (mouseTo.x - left) * (mouseTo.x - left) +
                  (mouseTo.y - top) * (mouseTo.y - top)
              ) / 2;
          canvasObject = new fabric.Ellipse({
            left: (mouseTo.x - left) / 2 + left,
            top: (mouseTo.y - top) / 2 + top,
            stroke: this.color,
            fill: "rgba(255, 255, 255, 0)",
            originX: "center",
            originY: "center",
            rx: Math.abs(left - mouseTo.x) / 2,
            ry: Math.abs(top - mouseTo.y) / 2,
            strokeWidth: this.drawWidth
          });
          break;
        case "rectangle": //长方形 // 按shift时画正方型
          this.color = '#336699'
          if (e.e.shiftKey) {
            mouseTo.x - left > mouseTo.y - top ? mouseTo.y = top + mouseTo.x - left : mouseTo.x = left + mouseTo.y - top
          }
          var path =
              "M " +
              mouseFrom.x +
              " " +
              mouseFrom.y +
              " L " +
              mouseTo.x +
              " " +
              mouseFrom.y +
              " L " +
              mouseTo.x +
              " " +
              mouseTo.y +
              " L " +
              mouseFrom.x +
              " " +
              mouseTo.y +
              " L " +
              mouseFrom.x +
              " " +
              mouseFrom.y +
              " z";
          canvasObject = new fabric.Rect({
            left: left,
            top: top,
            width:mouseTo.x-mouseFrom.x,
            height:mouseTo.y-mouseFrom.y,
            stroke: this.color,
            strokeWidth: this.drawWidth,
            fill: "#c4d3ea",
            hasControls: false,
            rx: 50,
            ry:50,
          });
          //也可以使用fabric.Rect
          break;
        case "text": //文本框
          this.textbox = new fabric.Textbox("", {
            left: mouseFrom.x,
            top: mouseFrom.y - 10,
            // width: 150,
            fontSize: 16,
            borderColor: this.color,
            fill: this.color,
            hasControls: false
          });
          this.canvas.add(this.textbox);
          this.textbox.enterEditing();
          this.textbox.hiddenTextarea.focus();
          break;
        default:
          break;
      }
      if (canvasObject) {
        // canvasObject.index = getCanvasObjectIndex();\
        this.canvas.add(canvasObject); //.setActiveObject(canvasObject)
        this.drawingObject = canvasObject;
      }
    }
  },
  mounted() {
    this.canvas = new fabric.Canvas("canvas", {
      // skipTargetFind: false, //当为真时，跳过目标检测。目标检测将返回始终未定义。点击选择将无效
      // selectable: false,  //为false时，不能选择对象进行修改
      // selection: false   // 是否可以多个对象为一组
    });
    this.canvas.selectionColor = "rgba(0,0,0,0.05)";
    this.canvas.on("mouse:down", this.mousedown);
    this.canvas.on("mouse:move", this.mousemove);
    this.canvas.on("mouse:up", this.mouseup);
    document.onkeydown = e => {
      // 键盘 delect删除所选元素
      if (e.keyCode == 46) {
        this.deleteObj();
      }
      // ctrl+z 删除最近添加的元素
      if (e.keyCode == 90 && e.ctrlKey) {
        this.canvas.remove(
            this.canvas.getObjects()[this.canvas.getObjects().length - 1]
        );
      }
    };
    // var imgElement = document.getElementById('img1');//声明我们的图片
    // var imgInstance = new fabric.Image(imgElement,{  //设置图片位置和样子
    //   left:845,
    //   top:315,
    //   width:250,
    //   height:240,
    //   hasControls:false,
    //   lockMovementX:true,
    //   lockMovementY:true,
    //   adjustPosition:'center'
    // });
    //
    // this.canvas.add(imgInstance);//加入到canvas中

  }
};
</script>

<style  lang="scss" scoped>
.box {
  width: 200px;
  height: 100px;
}
.el-header {
  background-color: #292929;
  color: #333;
  line-height: 60px;
}

.el-aside {
  background-color: #292929;
  color: #333;
  text-align: center;
}
.el-menu {
  border-bottom: #292929;
}

.pic1 {
  background-image: url("../assets/peer.png");
  background-size: cover;
  position: absolute;
  /*background-color: black;*/
}
.pic2 {
  /*background-image: url("../assets/organization.png");*/
  background-size: cover;

}
.pic3 {
  background-color: blue;
}
.pic0 {
  background-color: white;
}
.org0 {
  background-color: white;
}
.org1 {
  background-image: url("../assets/organization.png");
  background-size: cover;
  position: absolute;
}
.org2 {
  background-color: blue;
}
.app0 {
  background-color: white;
}
.app1 {
  background-image: url("../assets/application.png");
  background-size: cover;
  position: absolute;
}
.cha0 {
  background-color: white;
}
.cha1 {
  background-image: url("../assets/channel.png");
  background-size: cover;
  position: absolute;
}
.blo0 {
  background-color: white;
}
.blo1 {
  background-image: url("../assets/blockchain.png");
  background-size: cover;
  position: absolute;
}
img,
input {
  display: none;
}
.demo {
  display: flex;
  flex-direction: column;
  align-items: center;
}
canvas {
  border: 1px dashed black;
}
.el-button--orange {
  color: #fff;
  background-color: #FC813B;
  border-color: #FC813B;
}
.el-button--orange:hover {
  color: white;
  background-color: orange;
  border-color: orange;
}
.el-button--purple {
  color: #fff;
  background-color: #8c25dc;
  border-color: #8c25dc;
}
.el-button--purple:hover {
  color: #fff;
  background-color: #8d43c7;
  border-color: #8d43c7;
}
.el-button--red {
  color: #fff;
  background-color: red;
  border-color: red;
}
.el-button--red:hover {
  color: #fff;
  background-color: tomato;
  border-color: tomato;
}
.el-button--green:hover {
  color: #fff;
  background-color: darkgreen;
  border-color: darkgreen;
}
.el-button--green {
  color: #fff;
  background-color: #134706;
  border-color: #134706;
}
.el-button--yellow:hover {
  color: #fff;
  background-color: gold;
  border-color: gold;
}
.el-button--yellow {
  color: #fff;
  background-color: #f3c939;
  border-color: #f3c939;
}
.draw-btn-group {
/*// width: 1270px;*/
  margin-top: 10px;
  display: flex;
  align-items: center;
  justify-content: flex-start;
& > div {
    background: #fafafa;
    cursor: pointer;
&:hover {
   background: #eee;
 }
i {
  display: flex;
  background-repeat: no-repeat;
  background-size: 80%;
  background-position: 50% 50%;
  height: 30px;
  width: 30px;
}
  .icon-1 {
    background-image: url("../assets/icons/draw/1.png");
  }
  .icon-pentagram {
  background-image: url("../assets/icons/draw/pentagram.png");
  }
  .icon-2 {
   background-image: url("../assets/icons/draw/2.png");
  }
  .icon-3 {
    background-image: url("../assets/icons/draw/3.png");
  }
  .icon-4 {
    background-image: url("../assets/icons/draw/4.png");
    background-size: 75%;
  }
  .icon-5 {
    background-image: url("../assets/icons/draw/5.png");
    background-size: 70%;
  }
  .icon-6 {
    background-image: url("../assets/icons/draw/6.png");
  }
  .icon-7 {
    background-image: url("../assets/icons/draw/7.png");
    background-size: 80%;
  }
  .icon-del {
    background-image: url("../assets/icons/draw/del.png");
    background-size: 90%;
  }
  .icon-img {
    background-image: url("../assets/icons/draw/img.png");
    background-size: 80%;
  }
  .icon-back {
    background-image: url("../assets/icons/draw/back.png");
    background-size: 75%;
  }
  .icon-save {
    background-image: url("../assets/icons/draw/save.png");
    background-size: 80%;
  }
  .icon-zip {
    background-image: url("../assets/icons/draw/zip.png");
    background-size: 72%;
  }
  .icon-mouse {
    background-image: url("../assets/icons/draw/mouse.png");
    background-size: 60%;
  }
}
.active {
  background: #eee;
}
}
</style>