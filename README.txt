Asutosh Dhakal
ad42324

Rohan Arya
ra34586

CS361 Assignment 1

We started off by creating subject, object, secure system, reference monitor, security level, and instruction classes to 
model the requirements from the assignment description. 

Once developed the skeleton for these classes, we implemented the parsing for each instruction in the SecureSystem.java class and turned it into
an instruction object. For every instruction that was parsed, we passed it into the reference monitor which acted as the place in which read and
write operations were done. If there was a bad read, the reference monitor would handle it by resetting the subject's temp variable to 0. 

For the security level class we simply had two static int variables representing high and low levels. High was 1 and low was 0. 

Every instruction object had it's own subject and object variables as well as an instruction type associated with that operation. We also 
had a static BAD INSTRUCTION variable that mimicked an instruction object with null attributes. 

For this assignment, we only had to worry about two subjects and two objects, so managing the state was simple. 

We finished all of the requirements for this assignment.


