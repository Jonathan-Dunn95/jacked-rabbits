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
  props: {
    mascots: [

    ]
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
  margin: 20px;
}
img { 
  border: 4px solid var(--primary800);
  border-radius: 0.25rem;
  height: 75%;
  width: 75%;
}
</style>