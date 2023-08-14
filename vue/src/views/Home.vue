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
  data() {
    return {

    };
  },
  created() {
    let userType = this.$store.state.user.authorities[0].name;
    if(userType === "ROLE_PARENT") {
      this.$router.push("/parents")
    }
    else if(userType === "ROLE_KID") {
      this.$router.push("/closet")
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
