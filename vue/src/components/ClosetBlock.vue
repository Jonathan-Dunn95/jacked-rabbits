<template>
  <div class="container">
    <div class="nav-tabs">
      <button @click="selectCategory('Shirts')" :class="{ active: selectedCategory === 'Shirts' }">Shirts</button>
      <button @click="selectCategory('Shoes')" :class="{ active: selectedCategory === 'Shoes' }">Shoes</button>
      <button @click="selectCategory('Hats')" :class="{ active: selectedCategory === 'Hats' }">Hats</button>
      <button @click="selectCategory('Accessories')" :class="{ active: selectedCategory === 'Accessories' }">Accessories</button>
      <button @click="selectCategory('Backgrounds')" :class="{ active: selectedCategory === 'Backgrounds' }">Backgrounds</button>
    </div>
    <div class="item-grid">
      <img v-for="(item, index) in displayedItems" 
      :key="index" 
      :src="item.image" 
      :class="{ selected: index === selectedItemIndex }" 
      @click="selectItem(index)"/>
    </div>
  </div>
</template>

<script>
export default {
  name: "closet-block",
  data() {
    return {
      selectedCategory: 'Shirts',
      selectedItemIndex: null,
      items : [
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt1.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt2.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt3.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt4.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt5.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt6.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt7.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt8.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt9.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt10.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt11.jpg',
        },
        {
          category: 'Shirts',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt12.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes1.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes2.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes3.jpg',
        },
                {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes4.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes5.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes6.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes7.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes8.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes9.jpg',
        },
                {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes10.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes11.jpg',
        },
        {
          category: 'Shoes',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes12.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat1.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat2.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat3.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat4.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat5.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat6.jpg',
        },
                {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat7.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat8.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat9.jpg',
        },
                {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat10.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat11.jpg',
        },
        {
          category: 'Hats',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat12.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc1.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc2.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc13.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc4.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc5.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc6.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc7.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc8.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc9.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc10.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc11.jpg',
        },
        {
          category: 'Accessories',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc12.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back1.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back2.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back3.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back4.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back5.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back6.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back7.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back8.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back9.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back10.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back11.jpg',
        },
        {
          category: 'Backgrounds',
          image: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back12.jpg',
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
    selectItem(index) {
      this.selectedItemIndex = index;
    },
  },
}
</script>

<style scoped>
.container { 
  display: flex;
  border: 10px solid var(--primary800);
  background-color: var(--primary400);
  margin: 20px;
  border-radius: 0.5rem;
}
.nav-tabs {
  display: flex;
  margin-bottom: 2rem;
  border-bottom: 10px solid var(--primary800);
  background-color: var(--primary800);
}
.nav-tabs button {
  flex: 1;
  border-radius: 0.5rem;
  height: 5rem;
  cursor: pointer;
}
.item-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin-bottom: 1rem;
  background-color: var(--primary400);
}
.item-grid img {
  max-width: 275px;
  max-height: 275px;
  width: 100%;
  border: 4px solid var(--primary800);
  margin-bottom: 1rem;
  border-radius: 0.5rem;
  cursor: pointer;
}
.nav-tabs button.active {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
.item-grid img.selected {
  border-color: var(--primary600);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}
</style>