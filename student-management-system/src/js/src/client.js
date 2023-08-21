import axios from 'axios';

const checkStatus = response => {
  if (response.status >= 200 && response.status < 300) {
    return response;
  } else {
    const error = new Error(response.statusText);
    error.response = response;

    if (response.data) {
      error.error = response.data;
    }

    return Promise.reject(error);
  }
};

const instance = axios.create({
  baseURL: 'http://localhost:8080/api'
});

export const getAllStudents = () => instance.get('/students').then(checkStatus);

export const addNewStudent = student => instance.post('/students', student);