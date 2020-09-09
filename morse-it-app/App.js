import React, { useState } from "react";
import { Button, Text, StyleSheet, StatusBar, View } from "react-native";
import Constants from "expo-constants";
import MessageComponent from './Components/MorseItMessageComponent'
import SockJsClient   from 'react-stomp';
import * as MYConstants from './Utils/MorseitConstants'
 import SignupForm from './Components/MorseitSignup'


const App = () => {
  const styleTypes = ['default','dark-content', 'light-content'];
  const [visibleStatusBar, setVisibleStatusBar] = useState(false);
  const [styleStatusBar, setStyleStatusBar] = useState(styleTypes[0]);
  const [messages, setMessages] = useState([])
  const [user, setUser] = useState(null)

  const changeVisibilityStatusBar = () => {
    setVisibleStatusBar(!visibleStatusBar);
  };

  const changeStyleStatusBar = () => {
    const styleId = styleTypes.indexOf(styleStatusBar) + 1;

    if(styleId === styleTypes.length){
      return setStyleStatusBar(styleTypes[0]);
    }
    return setStyleStatusBar(styleTypes[styleId]);
  };

  const decryptMessage = () =>{
    
  }
  let handleLoginSubmit = (username) => {
    console.log(username, " Logged in..");

    setUser({
      username: username,
      color: "blue"
    })

  }
  return (
    <View style={styles.container}>
      
    {!!user ?(
      <View>
        <Text>{user.username}</Text>
        <MessageComponent message={user.username}></MessageComponent>
      </View>
      ):
       <SignupForm onSubmit={handleLoginSubmit}/>
      }
      <StatusBar backgroundColor="#006064" barStyle={styleStatusBar} hidden={visibleStatusBar} />
      <Button title="Logout" onPress={()=>{setUser([])}}></Button>
     
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    alignContent:'flex-start',
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#ECF0F1',
    padding: 8
  },
  buttonContainer:{
    padding: 10,
    width: 200
  },
  textStyle:{
    textAlign: 'center'
  }
});

export default App;
