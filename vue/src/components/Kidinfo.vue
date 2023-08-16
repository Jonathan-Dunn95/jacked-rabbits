<template>
  <div class="kid-info">
    <p>Carrots: {{ kid.carrots }}</p>
    <p>Steps: {{ getActivity(kid).steps }}</p>
    <p>Minutes of Activity: {{ getActivity(kid).minutes }}</p>
  </div>
</template>
<script>
import KidService from "../services/KidService.js";
export default {
//   props: {
//     kid: Object,
//     activities: Array,
//   },
created() {
    KidService.getKids(this.$store.state.user.id).then(response => {
      if(response.status === 200) {
        //success
        this.$store.commit("SET_KIDS", response.data);
        // console.log(this.$store.state.kids)
      }
    })
    KidService.getActivities(this.$store.state.user.id).then(response => {
      if(response.status === 200) {
        //success
        this.$store.commit("SET_ACTIVITIES", response.data);
        console.log(this.$store.state.kids)
      }
    })
  },
  computed: {
    isFormShown() {
      return this.currentKidId > 0;
    },
    kids() {
      return this.$store.state.kids;
    },
    activties() {
      return this.$store.state.activties
    },
    carrots(){
        return this.$store.state.carrots
},
  },
  methods: {
    getActivity(kid) {
      return this.activities.find((activity) => activity.kidId === kid.kidId) || {
        steps: 0,
        minutes: 0,
      };
    }
  }
}
</script>
<style scoped>
/* Styles for KidInfo component */
</style>