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
.nav-list {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
  justify-content: center;
}
.nav-list li {
  margin: 0 1rem;
  font-size: 1.2rem;
  color: white;
  cursor: pointer;
  transition: color 0.3s;
}
.nav-list li:hover {
  color: var(--primary400);
}
</style>