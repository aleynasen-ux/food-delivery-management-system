<?xml version="1.0" encoding="UTF-8" ?>

<Form version="1.3" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
  </Properties>
  <SyntheticProperties>
    <SyntheticProperty name="formSizePolicy" type="int" value="1"/>
    <SyntheticProperty name="generateCenter" type="boolean" value="false"/>
  </SyntheticProperties>
  <AuxValues>
    <AuxValue name="FormSettings_autoResourcing" type="java.lang.Integer" value="0"/>
    <AuxValue name="FormSettings_autoSetComponentName" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_generateFQN" type="java.lang.Boolean" value="true"/>
    <AuxValue name="FormSettings_generateMnemonicsCode" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_i18nAutoMode" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_layoutCodeTarget" type="java.lang.Integer" value="1"/>
    <AuxValue name="FormSettings_listenerGenerationStyle" type="java.lang.Integer" value="0"/>
    <AuxValue name="FormSettings_variablesLocal" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_variablesModifier" type="java.lang.Integer" value="2"/>
  </AuxValues>

  <Layout>
    <DimensionLayout dim="0">
      <Group type="103" groupAlignment="0" attributes="0">
          <Group type="102" attributes="0">
              <Group type="103" groupAlignment="0" attributes="0">
                  <Group type="102" alignment="0" attributes="0">
                      <EmptySpace min="-2" pref="171" max="-2" attributes="0"/>
                      <Component id="jLabel1" min="-2" pref="235" max="-2" attributes="0"/>
                  </Group>
                  <Group type="102" alignment="0" attributes="0">
                      <EmptySpace min="-2" pref="231" max="-2" attributes="0"/>
                      <Group type="103" groupAlignment="1" attributes="0">
                          <Component id="btnOrderItem" min="-2" max="-2" attributes="0"/>
                          <Group type="103" groupAlignment="0" attributes="0">
                              <Component id="btnMenuItem" alignment="0" min="-2" max="-2" attributes="0"/>
                              <Group type="102" alignment="0" attributes="0">
                                  <EmptySpace min="6" pref="6" max="-2" attributes="0"/>
                                  <Component id="btnOrder" min="-2" max="-2" attributes="0"/>
                              </Group>
                              <Component id="btnCustomer" alignment="0" min="-2" max="-2" attributes="0"/>
                          </Group>
                      </Group>
                  </Group>
                  <Group type="102" alignment="0" attributes="0">
                      <EmptySpace min="-2" pref="198" max="-2" attributes="0"/>
                      <Component id="btnRestaurantManagement" min="-2" max="-2" attributes="0"/>
                  </Group>
              </Group>
              <EmptySpace pref="194" max="32767" attributes="0"/>
          </Group>
      </Group>
    </DimensionLayout>
    <DimensionLayout dim="1">
      <Group type="103" groupAlignment="0" attributes="0">
          <Group type="102" alignment="0" attributes="0">
              <EmptySpace min="-2" pref="10" max="-2" attributes="0"/>
              <Component id="jLabel1" min="-2" pref="44" max="-2" attributes="0"/>
              <EmptySpace type="separate" max="-2" attributes="0"/>
              <Component id="btnCustomer" min="-2" max="-2" attributes="0"/>
              <EmptySpace type="separate" max="-2" attributes="0"/>
              <Component id="btnMenuItem" min="-2" max="-2" attributes="0"/>
              <EmptySpace type="separate" max="-2" attributes="0"/>
              <Component id="btnOrder" min="-2" max="-2" attributes="0"/>
              <EmptySpace type="separate" max="-2" attributes="0"/>
              <Component id="btnOrderItem" min="-2" max="-2" attributes="0"/>
              <EmptySpace type="separate" max="-2" attributes="0"/>
              <Component id="btnRestaurantManagement" min="-2" max="-2" attributes="0"/>
              <EmptySpace pref="97" max="32767" attributes="0"/>
          </Group>
      </Group>
    </DimensionLayout>
  </Layout>
  <SubComponents>
    <Component class="javax.swing.JLabel" name="jLabel1">
      <Properties>
        <Property name="text" type="java.lang.String" value="Takeaway Restaurant Management System"/>
      </Properties>
    </Component>
    <Component class="javax.swing.JButton" name="btnCustomer">
      <Properties>
        <Property name="text" type="java.lang.String" value="Customer"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="btnCustomerActionPerformed"/>
      </Events>
    </Component>
    <Component class="javax.swing.JButton" name="btnMenuItem">
      <Properties>
        <Property name="text" type="java.lang.String" value="Menu Item"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="btnMenuItemActionPerformed"/>
      </Events>
    </Component>
    <Component class="javax.swing.JButton" name="btnOrder">
      <Properties>
        <Property name="text" type="java.lang.String" value="Order"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="btnOrderActionPerformed"/>
      </Events>
    </Component>
    <Component class="javax.swing.JButton" name="btnOrderItem">
      <Properties>
        <Property name="text" type="java.lang.String" value="Order Item"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="btnOrderItemActionPerformed"/>
      </Events>
    </Component>
    <Component class="javax.swing.JButton" name="btnRestaurantManagement">
      <Properties>
        <Property name="text" type="java.lang.String" value="Restaurant Management"/>
      </Properties>
      <Events>
        <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="btnRestaurantManagementActionPerformed"/>
      </Events>
    </Component>
  </SubComponents>
</Form>
