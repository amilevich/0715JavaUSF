select * from ers_reimbursement;

select * from ers_users;

cnVwZXJ0bzE=

select * from email;


UPDATE email
set email_subject = ', Welcome to Revature ERS Application',
email_message = '<h1>Thank you for joining the Revature Employee Reimbursement System!</h1> <p> You are now registered and we look forward to working with you. If you have any questions, please contact your Finance Manager for assistance.</p> <p>This email is auto-generated, please do not reply</p>'
where email_id = 1;
commit;

delete from ers_reimbursement;
delete from ers_users;