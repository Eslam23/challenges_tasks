fun main(args: Array<String>) {


    var row1 = arrayOf('#', '.','#' ,'#', '.','#' )
    var row2 = arrayOf('.', '#','#' , '#','#' , '.')
    var row3 = arrayOf('#', '.','#' , '#' ,'.','#')

    val seats = arrayOf(row1,row2, row3)
    var result : Int = maxStudents(seats)
    System.out.println(result)

}
fun  maxStudents(seats : Array<Array<Char>>) : Int {
    var number_of_rows : Int = seats.count()
    var number_of_columns : Int = seats[0].count()
    var valid = IntArray(number_of_rows)

    for ( i in 0 .. number_of_rows-1 )
    {

        var tmp : Int = 0

        for ( j in 0 .. number_of_columns-1 )
        {
            var temp : Int = 0
            if (seats[i][j] == '.')
            {
                temp = 1

            }
            tmp = tmp * 2 + temp
        }
        valid[i] = tmp;
    }

    //int maxSize = 1 << number_of_columns;
    var maxSize : Int = 1 shl number_of_columns
    var dp  = Array(number_of_rows) {IntArray(maxSize)}
    for ( i in 0 .. number_of_rows-1 )
    {
        for (j in 0 .. maxSize-1)
        {
            dp[i][j] = -1;
        }
    }


    var res : Int = 0

    for (i in 0 .. number_of_rows-1)
    {

        for (j in 0 .. maxSize-1)

        {
            if ((j and valid[i]) == j && ((j shr 1) and j) == 0)
            {
                if (i == 0)
                {
                    dp[i][j] = Math.max(dp[i][j], Integer.bitCount(j));
                }
                else
                {

                    for ( k in 0 .. maxSize-1)
                    {
                        if (dp[i - 1][k] != -1 && ((j shl 1) and k) == 0 && ((j shr 1) and k) == 0)
                        {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Integer.bitCount(j));
                        }
                    }
                }
            }
            res = Math.max(res, dp[i][j]);
        }

    }
    return res;
}
