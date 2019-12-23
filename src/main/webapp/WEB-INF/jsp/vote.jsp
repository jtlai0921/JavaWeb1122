<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['候選人', '得票數'],
                    ['蔡英文', ${sum1}],
                    ['韓國瑜', ${sum2}],
                    ['宋楚瑜', ${sum3}]
                ]);

                var options = {
                    title: '2020 總統大選'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>
    </head>
    <body>
        蔡英文: <progress value="${sum1}" max="100"></progress><p />
        韓國瑜: <progress value="${sum2}" max="100"></progress><p />
        宋楚瑜: <progress value="${sum3}" max="100"></progress><p />
        <div id="piechart" style="width: 900px; height: 500px;"></div>
    </body>
</html>
