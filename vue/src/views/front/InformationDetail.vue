<template>
  <div class="main-content">
    <div style="width: 60%; margin: 20px auto">
      <div style="color: #333333; font-size: 20px; font-weight: 700">{{ informationData.name }}</div>
      <div style="margin-top: 10px; color: #767474">
        <span style="font-weight: 600; color: #404040">
          <a href="#" @click="navTo('/front/DepartmentDetail?id=' + informationData.departmentId)">{{informationData.departmentName}}</a>
        </span>
        <span style="margin-left: 50px">发布时间：{{ informationData.time }}</span>
      </div>
      <div style="margin-top: 30px" v-html="informationData.description"></div>
    </div>
  </div>
</template>

<script>

export default {

  data() {
    let informationId = this.$route.query.id
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      informationData: {},
      informationId: informationId,
    }
  },
  mounted() {
    this.loadActivity()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadActivity() {
      this.$request.get('/information/' + this.informationId).then(res => {
        if (res.code === '200') {
          this.informationData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    navTo(url) {
      location.href = url
    },
  }
}
</script>
