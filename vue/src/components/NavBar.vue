<template>
<div class="navigation-bar">
  <nav>
    <ul class="nav-list">
      <li @click="navigateTo('parents')">Manage Children</li>
      <li @click="navigateTo('item-store')">Item Store</li>
      <li @click="navigateTo('closet')">Closet</li>
      <li @click="navigateTo('login')">Login</li>
      <li @click="navigateTo('logout')">Logout</li>
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
  text-align: right;
}
.nav-list li {
  display: inline;
  font-size: 1.5rem;
  font-weight: bolder;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s;
  position: relative;
  padding: 2rem;
}
.nav-list li:hover {
  color: var(--primary400);
  background-color: var(--primary400);
  color: var(--primary800);
}
</style>