fun main(args: Array<String>) {

    var row1 = arrayOf(-2, -3,3)
    var row2 = arrayOf(-5, -10,1)
    var row3 = arrayOf(10, 30,-5)

   val array = arrayOf(row1,row2, row3)
    var  result : Int = Calculate_Minimum_Iniitial_Health(array)
    System.out.println(result)
}
fun  Calculate_Minimum_Iniitial_Health(dungeon : Array<Array<Int>>) : Int {

    var result  = Array(dungeon.count()) {IntArray(dungeon[0].count()) }

    //int i = dungeon.length - 1; i >= 0; i--
    for ( i in dungeon.count() - 1 downTo 0) {
        //int[] row_element = dungeon[i];
        var row_element = dungeon[i]
        // int j = row_element.length - 1; j >= 0; j--
        for ( j in row_element.count() - 1 downTo 0) {
            //boolean check_rowEnd = i == dungeon.length - 1;
            //boolean check_columnEnd = j == row_element.length - 1;
           var check_rowEnd : Boolean = i ==  dungeon.count() - 1
            var check_columnEnd : Boolean = j ==  row_element.count() - 1

        if (check_rowEnd && check_columnEnd) {
            result[i][j] = dungeon[i][j];
        } else if (!check_rowEnd && !check_columnEnd)
        {
            result[i][j] = dungeon[i][j] - Math.min(result[i + 1][j], result[i][j + 1])
        }
        else
        {
            var temp : Int = 1
            var col_temp : Int = 1
            if(check_rowEnd)
                temp = 0
            if(check_columnEnd)
                col_temp = 0


            result[i][j] = dungeon[i][j] - result[i + temp][j + col_temp]
        }
        if( result[i][j] > 0 )
        {
            result[i][j] = 0
        }
        else if (result[i][j] <= 0 )
        {
            result[i][j] = -result[i][j]
        }


    }

    }

    return result[0][0] + 1;
}


