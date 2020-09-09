import React, { useState } from 'react';
import {View, Text, TextInput, Button} from 'react-native';

const SignupForm = ({ onSubmit }) => {

    const [username, setUsername] = useState("");
    let handleUserNameChange = (changed) => setUsername(changed);

    let handleSubmit = () => {
        onSubmit(username)
    } 

    return (
        <View>
            <Text>Sign Up</Text>
            <TextInput 
            placeholder="Can we have your name ?"
            onChangeText={(text) => setUsername(text)}            
            />
            <Button title="Submit" onPress={handleSubmit}></Button>
        </View>
    )
}

export default SignupForm