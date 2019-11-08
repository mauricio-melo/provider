CREATE TABLE provider (
  idt_provider                  BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name  	                    VARCHAR(255)          NOT NULL,
  address      	                VARCHAR(255)          NOT NULL,
  state      	                VARCHAR(255)          NOT NULL
);

CREATE TABLE product (
  idt_product                   BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name  	                    VARCHAR(255)          NOT NULL,
  state      	                VARCHAR(255)          NOT NULL,
  description      	            VARCHAR(255)          NOT NULL,
  price                         DECIMAL               NOT NULL
);

CREATE TABLE demand (
  idt_demand                    BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  status                        VARCHAR(255)          NOT NULL
);

CREATE TABLE demand_item (
  idt_demand_item               BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  idt_product                   BIGINT                NOT NULL,
  idt_demand                    BIGINT                NOT NULL,
  quantity	                    BIGINT                NOT NULL,
  FOREIGN KEY (idt_product)     REFERENCES product (idt_product),
  FOREIGN KEY (idt_demand)      REFERENCES demand (idt_demand)
);

insert INTO provider(name, address, state)
values('AREV Modas SP', 'Rua SP', 'SP');

insert INTO provider(name, address, state)
values('AREV Modas RJ', 'Rua RJ', 'RJ');

insert INTO product(name, state, description, price)
values('Calça Jeans', 'SP', 'Calça tamanho M', 199.99);

insert INTO product(name, state, description, price)
values('Calça Moletom', 'RJ', 'Calça tamanho M', 199.99);

