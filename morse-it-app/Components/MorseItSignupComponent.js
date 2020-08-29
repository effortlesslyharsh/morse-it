import React, {useState,useEffect} from 'react'
import {View,TextInput,Text} from 'react-native'
import auth from '@react-native-firebase/auth';
import { useState, useEffect } from 'react'

const SignupComponent = props =>{
  let [userEmail, setUserEmail] = useState('');
  let [userPassword, setUserPassword] = useState('');
    return(
        <View>
            <Text>
                Test
            </Text>
            <TextInput
            
            
            />


        </View>
    )

}

export default SignupComponent;