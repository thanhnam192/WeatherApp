# Weather Application
<h3>Weather Application allow user:</h3>
<ul>
  <li>Search current weather based on City</li>
  <li>Find a logs of weather</li>
  <li>Delete logs of weather</li>
  <li>Download logs of weather as csv file</li>
 </ul>

<p><b>This application is deployed on AWS Elastic BeansTalk. We can use this app by open URL below:</b></p>
<p>http://weatherapplication-env.eba-ekieh9sk.ap-southeast-1.elasticbeanstalk.com/</p>

<h3>Database Consider</h3>
<p>Because we need to store a weather of every search as a log. We need to create <b>weather_log</b> table to store our weather logs. This table must have some comlumns as below: </p>
 <ul>
   <li>City: Because City is the Key for searching. Our table must have that city column and this colum should be <b>Indexes</b> to improve performance when we query a lot of data based on city </li>
  <li>country, weatherid, timetamps: we should have these columns for further searching criteria</li>
  <li>content: That column used to store all of data that we get from OpenWeather API as JSON. Because respone from API have many object properties and they can change overtime. It really complicated if we store each property object in seperated table. So that we can store all of them as Json Object instead.</li>
   </ul>
<p>We need to run <b>weather.sql</b> to create databe & table.</p>
