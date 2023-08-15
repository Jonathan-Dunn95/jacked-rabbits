<template>
  <div class="container">
    <img :src="equippedMascotUrl" />
  </div>
</template>

<script>

export default {
  data() {
    return {
      selectedMascot: null,
    };
  },
  computed: {
    equippedMascotUrl() {
      return this.$store.state.equippedMascot[0].url;
    }
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
  flex: 0 1 calc(25% - 1rem);
  border: 10px solid var(--primary800);
  border-radius: 0.25rem;
}
</style>