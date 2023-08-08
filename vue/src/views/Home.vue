<template>
  <div class="home">
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
  created() {
    if(this.$store.state.user.authorities[0].name === 'ROLE_PARENT') {
      this.$router.push('/kids')
    }
  }
};
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
