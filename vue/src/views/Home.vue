<template>
  <div class="home">
  </div>
  <input type="button" @click="testFunc">test
</template>

<script>
export default {
  name: 'Home',
  components: {

  },
  data(){
    return{

    }
  },
  methods: {
    testFunc(){
      alert(this.$store.state.login)
    },
  },
  created() {

  }
}
</script>

<style scoped>

</style>
