import axios from 'axios';

// TODO: Retrieve kids from parents

export default {
    getParents() { 
        return axios.get('/parents')
    },
    getKids(parentID) { 
        return axios.get(`/parents/${parentID}`)
    },
    getKid(parentID, kidID) { 
        return axios.get(`/parents/${parentID}`).then((response) => {
            const kids = response.data.kids;
            return kids.find(kid => kid.id == kidID);
        })
    },
}