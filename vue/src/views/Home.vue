<template>
  <div class="home">
      <div class="loading" v-if="isLoading">
      <img src="@/assets/game_loading.gif" alt="Loading..." />
    </div>
    <h1> 
      THIS IS THE HOME PAGE 
      <br><br>
      I THINK WE'RE GONNA REDIRECT PEOPLE FROM HERE
    </h1>
    <!-- <parents-page v-if="userType == 'parent'" />
    <kids-page v-if="userType == 'kid'" /> -->
  </div>
</template>

<script>
// import ParentPage from....
// import KidPage from...

export default {
  name: "home",
  data() {
    return {
      isLoading: true, 
      errorMsg: "", 
    };
  },
  created() {
    if(this.$store.state.user.authorities[0].name === 'ROLE_PARENT') {
      this.$router.push('/parents')
    } else {
      this.$router.push('/kids')
    }
  setTimeout(() => {
    this.isLoading = false; 
  }, 100000); 
}};
// computed: { 
//   userType() {
//     return this.$store.state.userType;
//   }
// }
// components: { 
//   ParentPage,
//   KidsPage,
// }
</script>

<style>

</style>
