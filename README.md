# Java technical test

I've taken 2 hours to finish up to the commit where I add a controller with no funcionality. This is the commit 58f0d88225f2a7f4e961f97322a28ab18d546eff, the time can be checked in the log so that was the limit of what I could do in that time.

Having said that, I'll continue this project tomorrow in order to finish it. So please check that the code that you'll see is the code up to that previous said point.

What I find still missing in the current implementation:

- Validations of Non-null fields, this can be checked with spring-validation.
- Add or update in a DB the information, probably H2, the update should happen only if the message received is newer(we cannot tell if the messages came in the correct order or not)
- Controller to DAO flow to get stored information.


A side note, this kind of flows goes well with Spring Batch. I didn't used it because I think it would make the challenge more a test to see how much I can use x framework. I used spring boot just because speeds things up.

