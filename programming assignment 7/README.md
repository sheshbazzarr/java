# Online Chat Application 

## Instruction:

developing a simple online chat application using Java. The application should allow multiple users to connect to a `central server`, `send messages`, and `receive messages` from other users.


## Requirements: 

### Server Implementation
*a.Server Setup*
- Create a server class, `ChatServer`, 
- Use ServerSocket to listen for incoming client connections.
- using socket programming to manage connections from multiple clients

*b.Handle Client Connections*
- Assign a unique user ID to each client upon connection.
- Maintain a list of connected clients in a data structure (like a `HashMap` or `List`)

*c.Broadcast Messages*
- When a message is received from a client, broadcast it to all connected clients
- Ensure that the server is capable of handling messages concurrently from multiple clients.
### Client Implementation(ChatClient)
*a.Client Setup*
- Create a `ChatClient` class
- Connect to the server using `Socket`
- Create a separate thread to handle incoming messages from the server so that the user can continue typing while messages are received.

*b.sending Messages*
- Implement a method for the client to send messages to the server.

*c.Receiving Messages*
- Implement a method to continuously listen for messages from the server and display them to the user.
### User Interface:
*a.Text-Based UI*
- Implement a simple text-based user interface.
- Allow the user to input their messages.
- Display received messages in real-time.
 