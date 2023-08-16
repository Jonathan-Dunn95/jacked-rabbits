<template>
  <div class="kid-info">
    <div class="counter">
      <p class="counter-label">🥕</p>
      <p class="counter-value carrot-value">{{ this.kid.carrots }}</p>
    </div>
    <div class="counter">
      <p class="counter-label">👣</p>
      <p class="counter-value steps-value">{{ this.activity.steps }}</p>
    </div>
    <div class="counter">
      <p class="counter-label">⏱️</p>
      <p class="counter-value minutes-value">{{ convertedPlayTime }}</p>
    </div>
  </div>
</template>
<script>
import KidService from '../services/KidService';
export default {
  name: "kid-info",
  data() {
    return {
      kid: null,
      activity: null,
    }
  },
  methods: {
    // getActivity(kid) {
    //   return (
    //     activities.find((activity) => activity.kidId === kid.kidId) || {
    //       steps: 0,
    //       minutes: 0,
    //     }
    //   );
    // },
  },
  computed: {
    convertedPlayTime() {
      return (parseInt(this.kid.playTime)/60) + "M"
    }
  },
  created() {
    KidService.getKidById(this.$store.state.user.id).then(response => {
      this.kid = response.data;
    })
    KidService.getActivity(this.$store.state.user.id).then(response => {
      this.activity = response.data;
    })
  }
};
</script>
<style scoped>
.kid-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #3366FF;
  padding: 15px 20px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  animation: dynamicBackground 10s infinite alternate;
  border: 10px solid var(--primary800);
}
.counter {
  text-align: center;
}
.counter-label {
  font-size: 30px;
  margin: 0;
  padding-top: 5px;
}
.counter-value {
  font-size: 28px;
  margin: 0;
  font-weight: bold;
  animation: bounce 0.5s infinite alternate;
}
.carrot-value {
  color: #F7B733;
}
.steps-value {
  color: #FF6347;
}
.minutes-value {
  color: #00BFFF;
}
@keyframes dynamicBackground {
  0% {
    background-color: var(--primary400);
  }
  50% {
    background-color: var(--primary400);
  }
  100% {
    background-color: var(--primary400);
  }
}
@keyframes bounce {
  0% {
    transform: translateY(0);
  }
  100% {
    transform: translateY(-5px);
  }
}
</style>