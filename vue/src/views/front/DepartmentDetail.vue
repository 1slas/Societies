<template>
  <div class="main-content">
    <div style="width: 60%; margin: 20px auto">
      <div style="color: #333333; font-size: 20px; font-weight: 700">{{ departmentData.name }}：社团介绍，欢迎你的加入！
        <el-button type="primary" @click="init">申请加入</el-button>
      </div>
      <div style="margin-top: 10px; color: #767474">发布时间：{{ departmentData.time }}</div>
      <div style="margin-top: 30px" v-html="departmentData.description"></div>

      <div style="margin-top: 50px; font-size: 18px">欢迎发表您宝贵的意见</div>
      <div style="margin-top: 20px">
        <el-input type="textarea" :rows="5" v-model="content"></el-input>
      </div>
      <div style="margin-top: 10px; text-align: right">
        <el-button type="primary" @click="submit(content, 0)">提交</el-button>
      </div>
      <div style="margin-top: 30px; margin-bottom: 500px">
        <el-row v-for="item in commentData" style="margin-bottom: 30px">
          <el-col :span="4">
            <div style="display: flex; align-items: center;">
              <img :src="item.userAvatar" alt="" style="width: 50px; height: 50px; border-radius: 50%">
              <div style="flex: 1; margin-left: 10px">{{item.userName}}</div>
            </div>
          </el-col>
          <el-col :span="20">
            <div style="height: 50px; line-height: 50px">
              <el-row>
                <el-col :span="18" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">{{item.content}}</el-col>
                <el-col :span="6" style="text-align: right">{{item.time}}</el-col>
              </el-row>
            </div>
            <div v-for="child in item.children" style="margin-bottom: 5px">
              <el-row>
                <el-col :span="5">
                  <div style="display: flex; align-items: center;">
                    <img :src="child.userAvatar" alt="" style="width: 50px; height: 50px; border-radius: 50%">
                    <div style="flex: 1; margin-left: 10px">{{ child.userName }} 回复：</div>
                  </div>
                </el-col>
                <el-col :span="13" style="height: 50px; line-height: 50px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">{{child.content}}</el-col>
                <el-col :span="6" style="height: 50px; line-height: 50px; text-align: right">{{child.time}}</el-col>
              </el-row>
            </div>
            <div style="margin-top: 20px">
              <el-input style="width: 400px" v-model="item.tmp"></el-input>
              <el-button type="primary" style="margin-left: 5px" @click="submit(item.tmp, item.id)">回复</el-button>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>


    <el-dialog title="填写信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form label-width="100px" style="padding-right: 50px">
        <el-form-item prop="description" label="申请说明">
          <el-input v-model="description" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

export default {

  data() {
    let departmentId = this.$route.query.id
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      departmentData: {},
      departmentId: departmentId,
      fromVisible: false,
      description: null,
      content: null,
      commentData: []
    }
  },
  mounted() {
    this.loadDepartment()
    this.loadComment()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    submit(content, parentId) {
      let data = {
        userId: this.user.id,
        departmentId: this.departmentId,
        content: content,
        parentId: parentId,
      }
      this.$request.post('/comment/', data).then(res => {
        if (res.code === '200') {
          this.$message.success('评论成功')
          this.content = null
          this.loadComment()
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    loadComment() {
      this.$request.get('/comment/selectAll?departmentId=' + this.departmentId).then(res => {
        if (res.code === '200') {
          this.commentData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    loadDepartment() {
      this.$request.get('/department/' + this.departmentId).then(res => {
        if (res.code === '200') {
          this.departmentData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    init() {
      this.fromVisible = true
    },
    save() {
      let data = {
        userId: this.user.id,
        departmentId: this.departmentId,
        description: this.description
      }
      this.$request.post('/apply/', data).then(res => {
        if (res.code === '200') {
          this.$message.success('申请成功，等待社长审核，您可以在申请的社团查看审核进度')
          this.fromVisible = false
        } else {
          this.$message.error(res.msg)
        }
      })
    }
  }
}
</script>
