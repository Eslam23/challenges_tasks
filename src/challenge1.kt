import java.util.*

fun main(args: Array<String>) {
    //var  str : String = readLine().toString()
   // var  pattern : String = readLine().toString()
    var  str : String = "adceb"
    var  pattern : String = "*a*b"



    if (match_string(str, pattern, str.length,
            pattern.length) == 1)
        System.out.println("TRUE")
    else
        System.out.println("FALSE")


}
 fun  match_string( str : String,  pattern : String,
 string_length : Int ,  pattern_length : Int) : Int
{

    // NO pattern Return false
    if (pattern_length == 0)
        return (0);

    var result_for_each_char  = Array(string_length + 1) {IntArray(pattern_length + 1) { 1 }}


    // initialize result_for_each_char table to false

    for ( i in 0 ..string_length )
        for (j in 0 ..pattern_length )
          result_for_each_char[i][j] = 0

    result_for_each_char[0][0] = 1

    // Only '*' can match with empty string
    for ( j in 1 ..pattern_length )
    if (pattern[j - 1] == '*') result_for_each_char[0][j] = result_for_each_char[0][j - 1];

    // fill the table in bottom-up fashion
    for ( i in 1 ..string_length)
    {

        for ( j in 1 ..pattern_length )
        {

            if (pattern[j-1] == '*')
                result_for_each_char[i][j] = result_for_each_char[i - 1][j]
                       // result_for_each_char[i][j - 1]

                      //  || result_for_each_char[i - 1][j]


            else if (pattern[j - 1 ] == '?'
                || str[ i - 1 ] == pattern[j - 1 ])
                result_for_each_char[i][j] = result_for_each_char[i - 1][j - 1];
            else
                result_for_each_char[i][j] = 0;
        }
    }

    return result_for_each_char[string_length][pattern_length]
}



