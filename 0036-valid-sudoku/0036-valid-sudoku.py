class Solution(object):
    def isValidSudoku(self, board):
        num_rows = len(board)
        num_cols = len(board[0])
        elems_appeared_row_wise = dict()
        elems_appeared_col_wise = dict()
        elems_appeared_box_wise = dict()

        for i in range(num_rows):
            for j in range(num_cols):
                if board[i][j] == '.':
                    continue
                    
                if i in elems_appeared_row_wise:
                    set_of_elems_in_row = elems_appeared_row_wise[i]
                    if board[i][j] in set_of_elems_in_row:
                        return False
                    else:
                        set_of_elems_in_row.add(board[i][j])
                        elems_appeared_row_wise[i] = set_of_elems_in_row
                else:
                    set_of_elems_in_row = set()
                    set_of_elems_in_row.add(board[i][j])
                    elems_appeared_row_wise[i] = set_of_elems_in_row
                    
                if j in elems_appeared_col_wise:
                    set_of_elems_in_col = elems_appeared_col_wise[j]
                    if board[i][j] in set_of_elems_in_col:
                        return False
                    else:
                        set_of_elems_in_col.add(board[i][j])
                        elems_appeared_col_wise[j] = set_of_elems_in_col
                else:
                    set_of_elems_in_col = set()
                    set_of_elems_in_col.add(board[i][j])
                    elems_appeared_col_wise[j] = set_of_elems_in_col
                    
                box_index = self.get_box_index(i, j)
                if box_index in elems_appeared_box_wise:
                    set_of_elems_in_box = elems_appeared_box_wise[box_index]
                    if board[i][j] in set_of_elems_in_box:
                        return False
                    else:
                        set_of_elems_in_box.add(board[i][j])
                        elems_appeared_box_wise[box_index] = set_of_elems_in_box
                else:
                    set_of_elems_in_box = set()
                    set_of_elems_in_box.add(board[i][j])
                    elems_appeared_box_wise[box_index] = set_of_elems_in_box
        return True
                
    def get_box_index(self, row, col):
        box_row = row // 3
        box_col = col // 3
        box_index = box_row * 3 + box_col
        return box_index