<template>
  <div class="container">
    <button v-on:click="addKid">Add Kid</button>
    <div class="kid-block">
      <ul v-if="kids.length > 0">
        <li v-for="kid in kids" v-bind:key="kid.kidId" class="kid-item">
          <div class="kid-info">
            <h2>{{ kid.username }}</h2>
            <div class="kid-details">
              <p>Steps: {{ getActivity(kid).steps }}</p> <!-- TODO: a=connect activity to this -->
              <p>Minutes of Activity: {{ getActivity(kid).minutes }}</p>
              <p>Carrots: {{ kid.carrots }}</p>
            </div>
          </div>
          <div class="buttons">
            <button v-on:click="showForm(kid.kidId)">Log Minutes/Steps</button>
            <!-- <button>View Account</button> -->
            <button v-on:click="deleteKid(kid)">Remove Kid</button>
          </div>
          </li>
        </ul>
        <form v-on:submit.prevent="updateKidActivity" class="log-minutes-form"  v-if="isFormShown">
          <label for="steps">Steps: </label>
          <input type="number" id="steps" v-model="activityForm.steps">
          <label for="minutes">Minutes: </label>
          <input type="number" id="minutes" v-model="activityForm.minutes">
          <button type="button" @click="updateKidActivity">Log Activity</button>
          <button v-on:click="hideForm">Cancel</button>
        </form>
      </div>
  </div>
</template>

<script>
import KidService from "../services/KidService.js";

export default {
  components: {
    // KidsService,
  },
  data() {
    return {
      activityForm: {
        steps: 0,
        minutes: 0
      },
      currentKidId: 0,
    }
  },
  methods: {
    // getKids() {
    //   KidsService.getKids(this.parentId)
    // },
    addKid() {
      this.$router.push('/parents/register')
      // KidService.createKid(this.$store.state.user.id, this.newKid).then(

      // )

    },
    showForm(kidId) {
      this.currentKidId = kidId;
    },
    hideForm() {
      this.currentKidId = 0;
    },
    updateKidActivity() {
      
  let updatedActivity = this.$store.state.activities.find(activity => activity.kidId === this.currentKidId);

  if (updatedActivity) {
    updatedActivity.steps += parseInt(this.activityForm.steps);
    updatedActivity.minutes += parseFloat(this.activityForm.minutes);
  }

  KidService.updateActivity(updatedActivity).then(() => {
    location.reload()
  })


  this.hideForm();

    
    },
    deleteKid(kid) {
      // let currentKid = this.$store.state.kids.find( kid => {
      //   return kid.id === kidId;
      // });
      // console.log(kid)
      if(confirm(`Are you sure you want to delete ${kid.username}`)) {
        KidService.deleteKid(kid.kidId).then( () => {
          this.$store.commit('DELETE_KID',kid)
        })
        
      }
    },
    getActivity(kid) {
      // console.log(this.$store.state.activities)
      return this.$store.state.activities.find( activity => {
        // console.log(activity)
        return activity.kidId === kid.kidId
      })
    }
  },
  computed: {
    isFormShown() {
      return this.currentKidId > 0;
    },
    kids() {
      return this.$store.state.kids;
    },
    activties() {
      return this.$store.state.activties
    }
  },
  created() {
    KidService.getKids(this.$store.state.user.id).then(response => {
      if(response.status === 200) {
        //success
        this.$store.commit("SET_KIDS", response.data);
        // console.log(this.$store.state.kids)
      }
    })
    KidService.getActivities(this.$store.state.user.id).then(response => {
      if(response.status === 200) {
        //success
        this.$store.commit("SET_ACTIVITIES", response.data);
        console.log(this.$store.state.kids)
      }
    })
  }
}

</script>

<style scoped>
  .kid-block {
    display: flex;
    flex-direction: column;
  }
  .kid-item {
    display: flex;
    align-items: center;
    margin: 20px;
    padding: 10px;
    border: 4px solid var(--primary400);
    border-radius: 5px;
    width: 100%;
  }
  .kid-info {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    flex: 1;
  }
  .kid-details {
    display: flex;
    flex-wrap: wrap;
    margin-top: 10px;
  }
  .kid-details > p {
    margin-right: 20px;
    font-size: 1.2rem;
  }
  button {
    border-radius: 0.25rem;
    background-color: var(--primary400);
    border: 2px solid;
    border-color: #1dc5ba;
    padding: 10px 20px;
    font-size: 1.2rem;
    color: var(--primary800);
    border: 3px solid var(--primary800);
    font-weight: bold;
    transition-duration: 0.4s;
  }
  button:hover {
    background-color: var(--primary800);
    border: 3px solid var(--primary400);
    color: white;
  }
  input[type="submit"] {
    background-color: #47d7ac;
    border: 2px solid;
    border-color: #1dc5ba;
    padding: 10px 20px;
    font-size: 18px;
    color: white;
    font-weight: bold;
  }
  li {
    display: flex;
    margin: 40px;
    background-color: #a8c2e7;
  }
  li > h2 {
    margin-right: 20px
  }
  .buttons > button {
    margin-right: 20px;
    margin-top: 10px;
  }
  form > * {
    margin-right: 20px
  }
  * {
  font-family: 'Montserrat', sans-serif;
}
</style>