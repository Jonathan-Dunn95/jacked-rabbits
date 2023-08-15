<template>
  <div class="kid-info">
    <p>Carrots: {{ kid.carrots }}</p>
    <p>Steps: {{ getActivity(kid).steps }}</p>
    <p>Minutes of Activity: {{ getActivity(kid).minutes }}</p>
  </div>
</template>

<script>
export default {
  props: {
    kid: Object,
    activities: Array,
  },
  methods: {
    getActivity(kid) {
      return this.activities.find((activity) => activity.kidId === kid.kidId) || {
        steps: 0,
        minutes: 0,
      };
    },
  },
};
</script>

<style scoped>
/* Styles for KidInfo component */
</style>
