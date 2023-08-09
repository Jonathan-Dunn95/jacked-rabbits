<template>
  <div class="container">
    <div class="nav-tabs">
      <button @click="selectCategory('Shirts')">Shirts</button>
      <button @click="selectCategory('Shoes')">Shoes</button>
      <button @click="selectCategory('Hats')">Hats</button>
      <button @click="selectCategory('Accessories')">Accessories</button>
      <button @click="selectCategory('Backgrounds')">Backgrounds</button>
    </div>
    <div class="item-grid">
      <img v-for="(item, index) in displayedItems" :key="index" :src="item.image" />
    </div>
  </div>
</template>

<script>
export default {
  props: {
  },
  data() {
    return {
      selectedCategory: 'Shirts',
      items : [
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shirts',
          image: require('../../img/hats/hat2.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
                {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
                {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
                {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Shoes',
          image: require('../../img/hats/hat1.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
                {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
                {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Hats',
          image: require('../../img/hats/hat5.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Accessories',
          image: require('../../img/hats/hat3.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
        {
          category: 'Backgrounds',
          image: require('../../img/hats/hat4.jpg'),
        },
      ],
    };
  },
  computed: {
    displayedItems() {
      if (!this.selectedCategory) return this.items;
      return this.items.filter(item => item.category === this.selectedCategory);
    },
  },
  methods: {
    selectCategory(category) {
      this.selectedCategory = category;
    },
  },
}
</script>

<style scoped>
.container { 
  display: flex;
  align-items: center;
  justify-content: center;
  border: 10px solid var(--primary800);
  background-color: var(--primary400);
  width: 100%;
  margin: 20px;
    border-radius: 0.5rem;

}
.nav-tabs {
  display: flex;
  justify-content: space-evenly;
  width: 100%;
  margin-bottom: 2rem;
  border-bottom: 10px solid var(--primary800);
  background-color: var(--primary800);
}
.nav-tabs button {
  flex: 1;
  border-radius: 0.5rem;
  height: 5rem;
}
.item-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin-bottom: 1rem;
  background-color: var(--primary400);

}
.item-grid img {
  flex: 0 1 calc(25% - 1rem);
  max-width: calc(25% - 1rem);
  width: 100%;
  height: 100%;
  object-fit: cover;
  border: 4px solid var(--primary800);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
}
</style>