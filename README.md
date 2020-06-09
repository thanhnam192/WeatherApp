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

<h3>Setup required</h3>
<ul>
  <li>Open <b>application.properties</b> and update correct jdbc.url, jdbc.username, jdbc.password </li>
  <li>Run <b>weather.sql</b> to create databe & table.</li>
  <li>Run mvn clean install</li>
  <li>Upload war file to tomcat server</li>
</ul>

<h3>Testing guide</h3>
<table>
  <thead>
    <tr>
      <th>Steps</th>
      <th>Expectation</th>
     </tr>
  </thead>
  <tbody>
    <tr>
      <td>Do a search with correct city(such as Can Tho)</td>
      <td>
        <p>- Current weather will be show in table</p>
        <p>- Show more button will be showed</p>
      </td>
    </tr>
    <tr>
      <td>Click on Show More button</td>
      <td>
        <p>- Load all weather logs of current city </p>
        <p>- Each weather row will has delete button </p>
        <p>- Download button will be showned</p>
      </td>
    </tr>
    <tr>
      <td>Click on download button</td>
      <td>
        <p>Download all logs of current city as csv file</p>
      </td>
    </tr>
     <tr>
      <td>
        <p>Click on Delete button</p>
         <p>Confirm dialog will be showed</p>
        <p>Click on Yes button</p>
       </td>
      <td>
        <p>Delete selected row</p>
      </td>
    </tr>
         <tr>
      <td>
        <p>Click on Delete button</p>
         <p>Confirm dialog will be showed</p>
        <p>Click on No button</p>
       </td>
      <td>
        <p>Dialog will be closed</p>
      </td>
    </tr>
    <tr>
      <td>Search weather with incorrect city</td>
      <td>Not found message will be showed in table</td>
    </tr>
  </tbody>
</table>
