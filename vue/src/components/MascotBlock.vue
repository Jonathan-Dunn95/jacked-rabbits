<template>
  <div class="container">
    <img src="https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot1.jpg" />
  </div>
</template>

<script>

export default {
  data() {
    return {
      selectedMascot: null,
    };
  },
  methods: {
    onMascotSelected() {
      this.$emit('mascotSelected', this.selectedMascot);
    }
  },
}
</script>

<style scoped>
.container {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
}
img { 
  border: 10px solid var(--primary800);
  border-radius: 0.25rem;
  height: 60rem;
}
</style>