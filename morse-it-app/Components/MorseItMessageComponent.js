import React, { useState } from 'react'
import {View,Text,StyleSheet} from 'react-native'



const MessageComponent = props=>{
const changeVisibilityStatusBar =(message)=>{
        setMessage(message+"ciphered");
    
}
const [message,setMessage] = useState(props.message);
return(
    <View style={styles.messageContainer}>
       <Text onPress={() => changeVisibilityStatusBar(message)}>
           {message}
       </Text>
    </View>

);
}

const styles = StyleSheet.create({
    messageContainer :{
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    }

})

export default MessageComponent;