class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        symbols_to_values = {'I' : 1, 'V' : 5, 'X' : 10, 'L' : 50, 'C': 100, 'D' : 500, 'M' : 1000}
        special_values = {'IV' : 4, 'IX' : 9, 'XL' : 40, 'XC' : 90, 'CD' : 400, 'CM': 900}

        res = 0
        i = 0
        while i < len(s):
            symbol = s[i]
            grouped_symbol = symbol
            if i + 1 < len(s):
                grouped_symbol += s[i + 1]
            
            if  grouped_symbol in special_values:
                i += 2
                res += special_values[grouped_symbol]
            else:
                i += 1
                res += symbols_to_values[symbol]
        return res