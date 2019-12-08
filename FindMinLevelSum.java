/*
Given a binary tree, return the level of the tree with minimum sum.
For example, given the tree:

L1:                10
L1:           /          \
L2:          10          40
L1:        /    \      /    \
L3:       1      1     1     1
L3:      / \    / \   / \   / \
L4:     1   2  3   4 5   6 7   8
       
Return 3.
*/

/*
* Time and space complexity
    h: height of the tree 
    t: total number of node in the tree
  time:   O(t)

  space:  O( log(t) )
    find all node in tree: 
          2^h - 1 = t
          h * log(2) - log(1) = log(t)
          h * log(2) - 0 = log(t)
          h * log(2) = log(t)
          h = log(t)/log(2)
          h = ( 1/log(2) ) * log(t) : log(2) is a constant 
          h = log(t)
*/
