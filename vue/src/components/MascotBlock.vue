<template>
  <div class="container">
    <!-- <h1>Mascot here</h1> -->
    <img src="../../img/mascotplaceholder.jpg" />
  </div>
</template>

<script>

export default {
  data() {
    return {
    };
  },
  created() {
  },
  methods: {

  },
};
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