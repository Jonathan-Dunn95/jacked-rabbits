<template>
  <div id="register">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="input-container">
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit" id="registerButton">Create Account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'parent',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
h1 {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 1rem;
  color: var(--primary800);
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}
.form-input-group {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 1rem;
}
input[type="text"],
input[type="password"],
select {
  width: 100%;
  height: 1rem;
  padding: 0.5rem;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  font-size: 1rem;
  border-radius: 0.25rem;
  border: 1px solid var(--primary800);
  transition-duration: 0.4s;
}
input[type="text"]:focus,
input[type="password"]:focus,
select:focus {
  outline: none;
  border-color: var(--primary400);
  box-shadow: 0 0 0 0.125rem rgba(33, 150, 243, 0.25);
}
.input-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-bottom: 1rem;
}
label {
  margin-bottom: 0.5rem;
  text-align: center;
  color: var(--primary800);
  font: bold;
  margin-bottom: 0.75rem;

}
button {
  width: 100%;
  height: 2rem;
  margin-top: 1.5rem;
  border-radius: 0.25rem;
  font-size: 1.2rem;
  background-color: var(--primary400);
  color: var(--primary800);
  border: 3px solid var(--primary800);
  transition-duration: 0.4s;
}
button:hover {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
form {
  height: fit-content;
}
#register {
  display: flex;
  justify-content: center;
  height: 100vh;
}
#registerButton {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
}
* {
  font-family: 'Montserrat', sans-serif;
}
</style>
