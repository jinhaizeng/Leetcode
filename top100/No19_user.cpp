/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == NULL || n <= 0) {
            return head;
        }

        int length = 0;
        ListNode* listIndex = head;
        while (listIndex->next != NULL) {
            ++length;
            listIndex = listIndex->next;
        }

        int target = length - n + 1;
        if (target < 0) {
            return head;
        }
        listIndex = head;
        length = 0;
        while (length < target - 1) {
            ++length;
            listIndex = listIndex->next;
        }

        if (target == 0 && head->next != NULL) {
            head = head->next;
        } else if (target == 0 && head->next == NULL) {
            return NULL;
        } else {
            listIndex->next = listIndex->next->next;
        }

        return head;
    }
};