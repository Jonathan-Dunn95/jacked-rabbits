<template>
  <div class="home">
    <h1>Home</h1>
    <p>Hey guys</p>
  </div>
</template>

<script>
export default {
  name: "home",
  created() {
    if(this.$store.state.user.authorities[0].name === 'ROLE_PARENT') {
      this.$router.push('/kids')
    }
  }
};
</script>

<style>

</style>
