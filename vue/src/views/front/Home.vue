<template>
  <div class="main-content">
    <div style="width: 70%; margin: 20px auto">
      <el-carousel height="300px" style="border-radius: 10px">
        <el-carousel-item v-for="item in carousel" :key="item">
          <img :src="item" alt="" style="width: 100%; height: 300px; border-radius: 10px">
        </el-carousel-item>
      </el-carousel>
      <div>
        <el-row :gutter="20">
          <el-col :span="12">
            <div style="margin: 20px 0 20px 0; width: 130px; background-color: #f16f44; height: 30px; line-height: 30px; text-align: center; font-size: 18px; color: white; font-weight: bold; border-radius: 20px">社团活动</div>
            <div v-for="item in activityData">
              <el-row :gutter="5" style="margin-bottom: 10px">
                <el-col :span="4">
                  <img :src="item.img" alt="" style="width: 60px; height: 60px; border-radius: 10px">
                </el-col>
                <el-col :span="15">
                  <div style="font-weight: 550; font-size: 15px; color: #404040; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                    <a href="#" @click="navTo('/front/activityDetail?id=' + item.id)"> {{ item.name }} </a>
                  </div>
                  <div style="font-size: 13px; color: #404040; margin-top: 5px; overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;">{{ item.description }}</div>
                </el-col>
                <el-col :span="5">
                  <div style="height: 25px"></div>
                  <div style="color: #8d8a8a; text-align: right">{{ item.time }}</div>
                </el-col>
              </el-row>
            </div>
            <div style="text-align: right">
              <div class="pagination">
                <el-pagination
                    background
                    @current-change="handleActivityCurrentChange"
                    :current-page="activityPageNum"
                    :page-size="activityPageSize"
                    layout="prev, next"
                    :total="activityTotal">
                </el-pagination>
              </div>
            </div>
          </el-col>
          <el-col :span="12">
            <div style="margin: 20px 0 20px 0; width: 130px; background-color: #f16f44; height: 30px; line-height: 30px; text-align: center; font-size: 18px; color: white; font-weight: bold; border-radius: 20px">社团资讯</div>
            <div v-for="item in informationData">
              <el-row :gutter="20" style="height: 36px;">
                <el-col :span="19">
                  <a href="#" @click="navTo('/front/informationDetail?id=' + item.id)">{{item.name}}</a>
                </el-col>
                <el-col :span="5" style="color: #8d8a8a;">{{item.time}}</el-col>
              </el-row>
            </div>
            <div style="text-align: right">
              <div class="pagination">
                <el-pagination
                    background
                    @current-change="handleInformationCurrentChange"
                    :current-page="informationPageNum"
                    :page-size="informationPageSize"
                    layout="prev, next"
                    :total="informationTotal">
                </el-pagination>
              </div>
            </div>
          </el-col>
        </el-row>
      </div>
      <div>
        <div style="margin: 20px 0 0 0; width: 130px; background-color: #f16f44; height: 30px; line-height: 30px; text-align: center; font-size: 18px; color: white; font-weight: bold; border-radius: 20px">优秀社团</div>
        <div style="margin-top: 15px">
          <el-row :gutter="20">
            <el-col :span="5" v-for="item in departmentData">
              <img :src="item.img" alt="" style="border: 1px solid #cccccc; width: 100%; height: 196px; border-radius: 50%" @click="navTo('/front/departmentDetail?id=' + item.id)">
              <div style="text-align: center; margin-top: 10px; font-size: 16px">{{ item.name }}</div>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>

  </div>
</template>

<script>

export default {

  data() {
    return {
      carousel: [
        require('@/assets/imgs/lun-1.png'),
        require('@/assets/imgs/lun-2.png'),
        require('@/assets/imgs/lun-3.png'),
      ],
      departmentData: [],
      activityData: [],
      activityPageNum: 1,
      activityPageSize: 3,
      activityTotal: 0,

      informationData: [],
      informationPageNum: 1,
      informationPageSize: 6,
      informationTotal: 0,
    }
  },
  mounted() {
    this.loadDepartment()
    this.loadActivity()
    this.loadInformation()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadInformation(pageNum) {
      if (pageNum) this.informationPageNum = pageNum
      this.$request.get('/information/selectPage2', {
        params: {
          pageNum: this.informationPageNum,
          pageSize: this.informationPageSize,
        }
      }).then(res => {
        if (res.code === '200') {
          this.informationData = res.data?.list
          this.informationTotal = res.data?.total
        } else {
          this.$message.error(res.msg)
        }

      })
    },
    loadActivity(pageNum) {
      if (pageNum) this.activityPageNum = pageNum
      this.$request.get('/activity/selectPage2', {
        params: {
          pageNum: this.activityPageNum,
          pageSize: this.activityPageSize,
        }
      }).then(res => {
        if (res.code === '200') {
          this.activityData = res.data?.list
          this.activityTotal = res.data?.total
        } else {
          this.$message.error(res.msg)
        }

      })
    },
    loadDepartment() {
      this.$request.get('/department/selectAll').then(res => {
        if (res.code === '200') {
          this.departmentData = res.data
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    navTo(url) {
      location.href = url
    },
    handleActivityCurrentChange(pageNum) {
      this.loadActivity(pageNum)
    },
    handleInformationCurrentChange(pageNum) {
      this.loadInformation(pageNum)
    },
  }
}
</script>
<style scoped>
.el-col-5{
  width: 20%;
  max-width: 20%;
}
</style>
