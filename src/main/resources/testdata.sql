INSERT INTO NEWS (date, image, information, title)
VALUES (CURRENT_DATE, file_read(
        'C:\Users\1989a\IdeaProjects\animal-shelter\src\main\resources\static\images\bhupinder-singh-iqWxGiv-ZDY-unsplash.jpg'),
        'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.',
        'Lorem ipsum dolor sit');
INSERT INTO animal (age, image, found, lost, name)
VALUES (3,
        file_read(
                'C:\Users\1989a\IdeaProjects\animal-shelter\src\main\resources\static\images\amber-kipp-75715CVEJhI-unsplash.jpg'),
        false, true, 'Schnurrilost');
INSERT INTO animal (age, image, found, lost, name)
VALUES (4, file_read(
        'C:\Users\1989a\IdeaProjects\animal-shelter\src\main\resources\static\images\bhupinder-singh-iqWxGiv-ZDY-unsplash.jpg'),
        true, false, 'Schnurrifound');
INSERT INTO animal (age, image, found, lost, name)
VALUES (5, file_read(
        'C:\Users\1989a\IdeaProjects\animal-shelter\src\main\resources\static\images\jae-park-7GX5aICb5i4-unsplash.jpg'),
        false, false, 'Schnurri');