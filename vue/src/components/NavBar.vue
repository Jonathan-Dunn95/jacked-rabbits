<template>
<div class="navigation-bar">
  <nav>
    <ul class="nav-list">
      <li @click="navigateTo('item-store')">Item Store</li>
      <li @click="navigateTo('closet')">Closet</li>
    </ul>
  </nav>
</div>
</template>

<script>
export default {
    name: "nav-bar",
    methods: {
        navigateTo(view) {
        this.$router.push({ name: view });
        },
    }
}
</script>

<style scoped>
.navigation-bar {
  background-color: var(--primary800);
  padding: 1rem 0;
}
.nav-list li {
  display: inline;
  font-size: 2rem;
  color: white;
  cursor: pointer;
  transition: color 0.3s;
}
.nav-list li:hover {
  color: var(--primary400);
}
</style>